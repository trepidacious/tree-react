package org.rebeam.tree

import cats.data.StateT
import cats.implicits._
import org.rebeam.tree.codec._
import org.rebeam.tree.ot.{ClientState, CursorUpdate, ListRev, OTList, Operation, Rev}
import org.log4s.getLogger

/**
  * Implementation of STM using a Map and PRandom as State, intended for client-side operation
  */
object MapStateSTM {

  val logger = getLogger

  sealed trait Error {
    def message: String
  }

  case class IdNotFoundError[A](id: Id[A]) extends Error {
    def message: String = toString
  }

  case class UnstableError[A](msg: String) extends Error {
    def message: String = toString
  }

  case class OTListStateNotFoundError[A](list: OTList[A]) extends Error {
    def message: String = toString
  }

  /**
    * A data item, and the most recent transaction that update its value
    * @param data           The data value just after the transaction
    * @param transactionId  The transaction in which the value was set
    * @param idCodec        IdCodec for A
    * @tparam A             The type of data
    */
  case class DataRevision[A](data: A, transactionId: TransactionId, idCodec: IdCodec[A])

  sealed trait StateDelta[A] {
    def id: Id[A]
    def a: A
  }
  object StateDelta {
    case class Put[A](id: Id[A], a: A) extends StateDelta[A]
    case class Modify[A](id: Id[A], previousA: A, a: A) extends StateDelta[A]
  }

  case class StateData (
      nextGuid: Guid,
      map: Map[Guid, DataRevision[_]],
      otMap: Map[Guid, ClientState[_]],
      random: PRandom,
      context: TransactionContext,
      deltas: Vector[StateDelta[_]],
      hasNOps: Boolean,
      unstable: Boolean
  ) extends IdCodecs with DataSource {

    def getDataRevision[A](id: Id[A]): Option[DataRevision[A]] = map.get(id.guid).map(_.asInstanceOf[DataRevision[A]])

    def getClientState[A](list: OTList[A]): Option[ClientState[A]] = otMap.get(list.id.guid).map(_.asInstanceOf[ClientState[A]])

    def getData[A](id: Id[A]): Option[A] = getDataRevision(id).map(_.data)

    def updated[A](id: Id[A], a: A, transactionId: TransactionId)(implicit mCodecA: IdCodec[A]): StateData = {
      copy(map = map.updated(id.guid, DataRevision(a, transactionId, mCodecA)))
    }

    override def codecFor[A](id: Id[A]): Option[IdCodec[A]] =
      getDataRevision(id).map(_.idCodec)

    def get[A](id: Id[A]): Option[A] = getData(id)

    def getWithTransactionId[A](id: Id[A]): Option[(A, TransactionId)] = getDataRevision(id).map(dr => (dr.data, dr.transactionId))

    def getTransactionIdFromGuid(guid: Guid): Option[TransactionId] = map.get(guid).map(_.transactionId)

    def getOTListCursorUpdate[A](list: OTList[A]): Option[CursorUpdate[A]] = getClientState(list)

    def nextTransaction: StateData = {
      val ng = nextGuid.nextTransactionFirstGuid
      copy(
        nextGuid = ng,
        random = PRandom(ng),
        deltas = Vector.empty,
        hasNOps = false,
        unstable = false
      )
    }

    override def toString: String = s"StateData(${map.map{ case (k, v) => s"$k -> ${v.data} @ ${v.transactionId}"}})"
  }

  def emptyState: StateData = StateData(
    Guid.first,
    Map.empty,
    Map.empty,
    PRandom(0),
    TransactionContext(Moment(0), Guid.first.transactionId),
    Vector.empty,
    hasNOps = false,
    unstable = false
  )

  // An Error or an A
  type ErrorOr[A] = Either[Error, A]

  // A State using StateData, or an Error
  type MapState[A] = StateT[ErrorOr, StateData, A]

  implicit val stmInstance: STMOps[MapState] = new STMOps[MapState] {

    // S op
    private def rand[A](rf: PRandom => (PRandom, A)): MapState[A] =
      recordSOp >>
      StateT[ErrorOr, StateData, A](sd => {
        val (newRandom, a) = rf(sd.random)
        Right((sd.copy(random = newRandom), a))
      })

    /**
      * Record a U operation in state
      */
    private def recordUOp: MapState[Unit] = StateT.modify[ErrorOr, StateData](s => s.copy(hasNOps = true))

    /**
      * Record an S operation in state - if there are any U ops recorded previously, the state
      * will be marked as unstable, otherwise there is no effect.
      * Note that when processing U+S operations, be sure to record any U operations before S operations
      */
    private def recordSOp: MapState[Unit] = StateT.modify[ErrorOr, StateData](
      s => if (s.hasNOps) s.copy(unstable = true) else s
    )

    // U Op
    def get[A](id: Id[A]): MapState[A] =
      recordUOp >>
      StateT.inspectF[ErrorOr, StateData, A](_.getData(id).toRight(IdNotFoundError(id)))

    // Not classified as U/S itself - this is done on public operations only
    private def getDataState[A](id: Id[A]): MapState[DataRevision[A]] =
      StateT.inspectF[ErrorOr, StateData, DataRevision[A]](_.getDataRevision(id).toRight(IdNotFoundError(id)))

    private def getClientState[A](list: OTList[A]): MapState[ClientState[A]] =
      StateT.inspectF[ErrorOr, StateData, ClientState[A]](_.getClientState(list).toRight(OTListStateNotFoundError(list)))

    // Not classified as U/S itself - this is done on public operations only
    private def set[A](id: Id[A], a: A)(implicit idCodec: IdCodec[A]): MapState[Unit] = for {
      _ <- StateT.modify[ErrorOr, StateData](s => s.updated(id, a, s.context.transactionId))
    } yield ()

    // U Op
    def modifyF[A](id: Id[A], f: A => MapState[A]): MapState[A] = for {
      _ <- recordUOp
      ds <- getDataState(id)
      newData <- f(ds.data)
      _ <- set[A](id, newData)(ds.idCodec)
      _ <- StateT.modify[ErrorOr, StateData](sd => sd.copy(deltas = sd.deltas :+ StateDelta.Modify(id, ds.data, newData)))
    } yield newData

    // Note that all random ops are S, this is handled by `rand` function
    def randomInt: MapState[Int] = rand(_.int)
    def randomIntUntil(bound: Int): MapState[Int] = rand(_.intUntil(bound))
    def randomLong: MapState[Long] = rand(_.long)
    def randomBoolean: MapState[Boolean] = rand(_.boolean)
    def randomFloat: MapState[Float] = rand(_.float)
    def randomDouble: MapState[Double] = rand(_.double)

    // Neither U nor S - context is always the same, and does not read STM state
    def context: MapState[TransactionContext] = StateT.inspect(_.context)

    // Internal op to create a plain guid - this is not considered to be an S op directly - other
    // ops need to classify themselves as U or S
    private def newGuid: MapState[Guid] =
      StateT[ErrorOr, StateData, Guid](sd => {
        Right(
          (
            sd.copy(nextGuid = sd.nextGuid.next),
            sd.nextGuid
          )
        )
      })

    // S op
    def createGuid: MapState[Guid] = recordSOp >> newGuid

    // Here we know we are an S operation, and we may also be a U operation - see notes below for
    // correct sequence to ensure we do this properly
    def putF[A](create: Id[A] => MapState[A])(implicit idCodec: IdCodec[A]) : MapState[A] =
      for {
        // NOTE: we don't recordSOp here - we must do this later to detect instability, see later notes
        // Also note we use createPlainGuid to avoid recordSOp
        id <- newGuid.map(guid => Id[A](guid))
        // NOTE: Run create - this determines whether this is a U op
        a <- create(id)
        // NOTE: Now we record S operation, so that if `create` contained a U op we can respond by
        // flagging transaction as unstable
        _ <- recordSOp
        _ <- set(id, a)
        _ <- StateT.modify[ErrorOr, StateData](sd => sd.copy(deltas = sd.deltas :+ StateDelta.Put(id, a)))
      } yield a

    def createOTListF[A](create: MapState[List[A]])(implicit idCodec: IdCodec[OTList[A]]): MapState[OTList[A]] = for {
      // NOTE: we don't recordSOp here - we must do this later to detect instability, see later notes
      // Also note we use createPlainGuid to avoid recordSOp
      id <- newGuid.map(guid => Id[OTList[A]](guid))
      // NOTE: Run create - this determines whether this is a U op
      a <- create
      // Local data root handles a single client only - priority 0, starts up to date with server rev 0
      newCs = ClientState(priority = 0, server = ListRev(a, Rev(0)), local = a, pendingOp = None, buffer = None, previousLocalUpdate = None)
      _ <- StateT.modify[ErrorOr, StateData](sd =>
        sd.copy(
          otMap = sd.otMap.updated(id.guid, newCs),
        )
      )
      // NOTE: Now we record S operation, so that if `create` contained a U op we can respond by
      // flagging transaction as unstable
      _ <- recordSOp
      otList = OTList(id, a)
      // OTLists are still STM cells, they just have additional client state to permit operations to be applied,
      // so we'll set the new value and record the change as putting a new value
      _ <- set(id, otList)
      _ <- StateT.modify[ErrorOr, StateData](sd => sd.copy(deltas = sd.deltas :+ StateDelta.Put(id, otList)))
    } yield otList


    def otListOperation[A](list: OTList[A], op: Operation[A]): MapState[OTList[A]] = for {
      // Note that this is an S op since we require OT operations to be stable, but reads
      // no state so is not a U op
      _ <- recordSOp
      cs <- getClientState(list)
      // We act as a "disconnected" client, since we have no server-side. Just apply the operation locally.
      // If there was a server, we would send the operation as well, and then expect later to get a confirmation
      // which would result in `confirmedCs = newCs.withServerConfirmation._1`
      newCs = cs.withClientOp(op)._1
      newData = newCs.local
      _ <- StateT.modify[ErrorOr, StateData](sd =>
        sd.copy(
          otMap = sd.otMap.updated(list.id.guid, newCs),
        )
      )
      newList = list.copy(list = newData)
      // OTLists are still STM cells, they just have additional client state to permit operations to be applied,
      // so we'll set the new value and record the change as a modification
      ds <- getDataState(list.id)
      _ <- set(list.id, newList)(ds.idCodec)
      _ <- StateT.modify[ErrorOr, StateData](sd =>
        sd.copy(deltas = sd.deltas :+ StateDelta.Modify(list.id, ds.data, newList))
      )
    } yield {
      logger.debug(s"Applied $op to get $newData")
      newList
    }

  }
}
