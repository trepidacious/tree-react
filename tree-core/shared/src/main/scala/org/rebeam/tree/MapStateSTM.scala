package org.rebeam.tree

import cats.data.StateT
import cats.implicits._
import org.rebeam.tree.codec._
import org.rebeam.tree.ot.{ClientState, CursorUpdate, ListRev, OTList, Operation, Rev}

/**
  * Implementation of STM using a Map and PRandom as State, intended for client-side operation
  */
object MapStateSTM {

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
                         hasUOps: Boolean,
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
        hasUOps = false,
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
    hasUOps = false,
    unstable = false
  )

  // An Error or an A
  type ErrorOr[A] = Either[Error, A]

  // A State using StateData, or an Error
  type MapState[A] = StateT[ErrorOr, StateData, A]

  implicit val stmInstance: STMOps[MapState] = new STMOps[MapState] {

    /**
      * Record a U operation in state
      */
    private def recordUOp: MapState[Unit] = StateT.modify[ErrorOr, StateData](s => s.copy(hasUOps = true))

    /**
      * Inspect state for U operations
      * @return True if state has recorded U operations
      */
    private def inspectHasUOps: MapState[Boolean] = StateT.inspect[ErrorOr, StateData, Boolean](_.hasUOps)

    /**
      * Restore state of U operation tracking in state
      */
    private def restoreHasUOps(hasUOps: Boolean): MapState[Unit] = StateT.modify[ErrorOr, StateData](s => s.copy(hasUOps = hasUOps))

    /**
      * Record an S operation in state - if there are any U ops recorded previously, the state
      * will be marked as unstable, otherwise there is no effect.
      * Note that when processing U+S operations, be sure to record any U operations before S operations
      */
    private def recordSOp: MapState[Unit] = StateT.modify[ErrorOr, StateData](
      s => if (s.hasUOps) s.copy(unstable = true) else s
    )

    // S op, to support the randomXXX ops in TransactionOps, which are all S.
    private def rand[A](rf: PRandom => (PRandom, A)): MapState[A] =
      recordSOp >>
      StateT[ErrorOr, StateData, A](sd => {
        val (newRandom, a) = rf(sd.random)
        Right((sd.copy(random = newRandom), a))
      })

    // Note that all random ops are S, this is handled by `rand` function
    def randomInt: MapState[Int] = rand(_.int)
    def randomIntUntil(bound: Int): MapState[Int] = rand(_.intUntil(bound))
    def randomLong: MapState[Long] = rand(_.long)
    def randomBoolean: MapState[Boolean] = rand(_.boolean)
    def randomFloat: MapState[Float] = rand(_.float)
    def randomDouble: MapState[Double] = rand(_.double)

    // Neither U nor S - context is always the same, and does not read STM state
    // FIXME consider Moment value, which changes from client to server
    def context: MapState[TransactionContext] = StateT.inspect(_.context)


    // U Op - getting data is always U, and has no point otherwise
    override def get[A](id: Id[A]): MapState[A] =
      recordUOp >>
      StateT.inspectF[ErrorOr, StateData, A](_.getData(id).toRight(IdNotFoundError(id)))

    // Not classified as U/S itself - public operations are responsible for classifying
    private def getDataState[A](id: Id[A]): MapState[DataRevision[A]] =
      StateT.inspectF[ErrorOr, StateData, DataRevision[A]](_.getDataRevision(id).toRight(IdNotFoundError(id)))

    // Not classified as U/S itself - public operations are responsible for classifying
    private def getClientState[A](list: OTList[A]): MapState[ClientState[A]] =
      StateT.inspectF[ErrorOr, StateData, ClientState[A]](_.getClientState(list).toRight(OTListStateNotFoundError(list)))

    // Not classified as U/S itself - public operations are responsible for classifying
    private def set[A](id: Id[A], a: A)(implicit idCodec: IdCodec[A]): MapState[Unit] = for {
      _ <- StateT.modify[ErrorOr, StateData](s => s.updated(id, a, s.context.transactionId))
    } yield ()

    // U Op
    override def modifyF[A](id: Id[A], f: A => MapState[A]): MapState[A] = for {
      _ <- recordUOp
      ds <- getDataState(id)
      newData <- f(ds.data)
      _ <- set[A](id, newData)(ds.idCodec)
      _ <- StateT.modify[ErrorOr, StateData](sd => sd.copy(deltas = sd.deltas :+ StateDelta.Modify(id, ds.data, newData)))
    } yield newData

    // We discard the results of an operation, and use this to prevent any information read from the STM during the
    // operation from being passed to further operations. This means that the discard operation itself is not U.
    // Note that we still check whether f itself is unstable, this is done in the normal way as it runs, using
    // the existing hasUOps value of MapState.
    // We implement this by inspecting the hasUOps state before running f, then restoring the state afterwards.
    // We might expose this as a public operation in future, however it's not clear at the moment that it has
    // any uses except for modifyFUnit.
    private def discard[A](f: MapState[A]): MapState[Unit] = for {
      previouslyU <- inspectHasUOps
      _ <- f
      // Here we discard the value we created - it is still in the STM, but not exposed to subsequent operations
      _ <- restoreHasUOps(previouslyU)
    } yield ()

    // This is not a U op - we preserve the hasUOps state before running the modification, then
    // can restore the state again afterwards because we discard the result of modifyF(id, f). If modifyF(id, f) is
    // unstable, we will still flag the transaction as unstable as that op executes, but from the perspective of later
    // operations, it doesn't otherwise matter whether modifyF(id, f) reads STM state, since that state is discarded
    // by this function. Note that the state could later be read from the STM, e.g. using get, but of course this get
    // would be recorded as a U op itself.
    override def modifyFUnit[A](id: Id[A], f: A => MapState[A]): MapState[Unit] = discard(modifyF[A](id, f))

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

    // Here we know we are an S operation because we put a value, and we may also be a U operation from running
    // the create MapState - see notes below for correct sequence to ensure we do this properly
    override def putFWithId[A](create: Id[A] => MapState[A])(implicit idCodec: IdCodec[A]) : MapState[(A, Id[A])] =
      for {
        // NOTE: we use createGuid, and so flag the S operation at this point. We know that regardless of what
        // is done by `create`, we will put a value into the STM using this Guid, and data of type `A`, so only
        // U operations before this point can affect this.
        id <- createGuid.map(guid => Id[A](guid))
        // NOTE: Run create - this determines whether this is a U op, since any STM state read by `create` can
        // be exposed to later operations via the returned instance of A
        a <- create(id)
        _ <- set(id, a)
        _ <- StateT.modify[ErrorOr, StateData](sd => sd.copy(deltas = sd.deltas :+ StateDelta.Put(id, a)))
      } yield (a, id)

    // This is not a U op - we preserve the hasUOps state before running the modification, then
    // can restore the state again afterwards because we discard the result of create. If create is itself
    // unstable, we will still flag the transaction as unstable as that op executes, but from the perspective of later
    // operations, it doesn't otherwise matter whether create reads STM state, since that state is discarded
    // by this function. Note that the state could later be read from the STM, e.g. using get, but of course this get
    // would be recorded as a U op itself.
    def putFJustId[A](create: Id[A] => MapState[A])(implicit idCodec: IdCodec[A]): MapState[Id[A]] = for {
      previouslyU <- inspectHasUOps
      // Here we discard the value we created - it is still in the STM, but not exposed to subsequent operations
      id <- putFWithId(create).map(_._2)
      _ <- restoreHasUOps(previouslyU)
    } yield id

    def createOTListF[A](create: MapState[List[A]])(implicit idCodec: IdCodec[OTList[A]]): MapState[OTList[A]] = for {
      // NOTE: we don't recordSOp here (by using newGuid rather than createGuid) - we must do this later to detect
      // instability, see later notes
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
      // flagging transaction as unstable. This is because we require that createOTListF always creates exactly
      // the same data as an initial state
      _ <- recordSOp
      otList = OTList(id, a)
      // OTLists are still STM cells, they just have additional client state to permit operations to be applied,
      // so we'll set the new value and record the change as putting a new value
      _ <- set(id, otList)
      _ <- StateT.modify[ErrorOr, StateData](sd => sd.copy(deltas = sd.deltas :+ StateDelta.Put(id, otList)))
    } yield otList


    def otListOperation[A](list: OTList[A], op: Operation[A]): MapState[OTList[A]] = for {
      // Note that this is an S op since we require OT operations to be stable, and also
      // provides the (modified) OTList as a return, so is a U op. Record S Op first so we
      // don't make the operation automatically unstable - it is only unstable if there is a
      // previous U op,
      _ <- recordSOp
      _ <- recordUOp
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
      scribe.debug(s"Applied $op to get $newData")
      newList
    }

    def otListOperationUnit[A](list: OTList[A], op: Operation[A]): MapState[Unit] = discard(otListOperation(list, op))

  }

}
