package org.rebeam.tree

import cats.data.StateT
import cats.implicits._
import org.rebeam.tree.codec._
import org.rebeam.tree.ot.{ClientState, CursorUpdate, Operation}

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

  case class DataRevision[A](data: A, revId: RevId[A], idCodec: IdCodec[A])

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
      deltas: Vector[StateDelta[_]]
  ) extends IdCodecs with DataSource {

    def getDataRevision[A](id: Id[A]): Option[DataRevision[A]] = map.get(id.guid).map(_.asInstanceOf[DataRevision[A]])

    def getClientState[A](id: Id[List[A]]): Option[ClientState[A]] = otMap.get(id.guid).map(_.asInstanceOf[ClientState[A]])

    def getData[A](id: Id[A]): Option[A] = getDataRevision(id).map(_.data)

    def updated[A](id: Id[A], a: A, revId: RevId[A])(implicit mCodecA: IdCodec[A]): StateData = {
      copy(map = map.updated(id.guid, DataRevision(a, revId, mCodecA)))
    }

    override def codecFor[A](id: Id[A]): Option[IdCodec[A]] =
      getDataRevision(id).map(_.idCodec)

    def get[A](id: Id[A]): Option[A] = getData(id)

    def getWithRev[A](id: Id[A]): Option[(A, RevId[A])] = getDataRevision(id).map(dr => (dr.data, dr.revId))

    def revGuid(guid: Guid): Option[Guid] = map.get(guid).map(_.revId.guid)

    def getList[A](id: Id[List[A]]): Option[(List[A], CursorUpdate[A])] = for {
      list <- getData(id)
      clientState <- getClientState(id)
    } yield (list, clientState)

    def nextTransaction: StateData = {
      val ng = nextGuid.nextTransactionFirstGuid
      copy(
        nextGuid = ng,
        random = PRandom(ng),
        deltas = Vector.empty
      )
    }
  }

  def emptyState: StateData = StateData(
    Guid.first,
    Map.empty,
    Map.empty,
    PRandom(0),
    TransactionContext(Moment(0)),
    Vector.empty
  )

  // An Error or an A
  type ErrorOr[A] = Either[Error, A]

  // A State using StateData, or an Error
  type MapState[A] = StateT[ErrorOr, StateData, A]

  private def rand[A](rf: PRandom => (PRandom, A)): MapState[A] =
    StateT[ErrorOr, StateData, A](sd => {
      val (newRandom, a) = rf(sd.random)
      Right((sd.copy(random = newRandom), a))
    })

  implicit val stmInstance: STMOps[MapState] = new STMOps[MapState] {

    def get[A](id: Id[A]): MapState[A] =
      StateT.inspectF[ErrorOr, StateData, A](_.getData(id).toRight(IdNotFoundError(id)))

    private def getDataState[A](id: Id[A]): MapState[DataRevision[A]] =
      StateT.inspectF[ErrorOr, StateData, DataRevision[A]](_.getDataRevision(id).toRight(IdNotFoundError(id)))

    private def getClientState[A](id: Id[List[A]]): MapState[ClientState[A]] =
      StateT.inspectF[ErrorOr, StateData, ClientState[A]](_.getClientState(id).toRight(IdNotFoundError(id)))

    private def set[A](id: Id[A], a: A)(implicit idCodec: IdCodec[A]): MapState[Unit] = for {
      revGuid <- createGuid
      _ <- StateT.modify[ErrorOr, StateData](_.updated(id, a, RevId(revGuid)))
    } yield ()

    def modifyF[A](id: Id[A], f: A => MapState[A]): MapState[A] = for {
      ds <- getDataState(id)
      newData <- f(ds.data)
      _ <- set[A](id, newData)(ds.idCodec)
      _ <- StateT.modify[ErrorOr, StateData](sd => sd.copy(deltas = sd.deltas :+ StateDelta.Modify(id, ds.data, newData)))
    } yield newData

    def randomInt: MapState[Int] = rand(_.int)
    def randomIntUntil(bound: Int): MapState[Int] = rand(_.intUntil(bound))
    def randomLong: MapState[Long] = rand(_.long)
    def randomBoolean: MapState[Boolean] = rand(_.boolean)
    def randomFloat: MapState[Float] = rand(_.float)
    def randomDouble: MapState[Double] = rand(_.double)

    def context: MapState[TransactionContext] = StateT.inspect(_.context)

    private def createGuid: MapState[Guid] =
      StateT[ErrorOr, StateData, Guid](sd => {
        Right(
          (
            sd.copy(nextGuid = sd.nextGuid.next),
            sd.nextGuid
          )
        )
      })

    def putF[A](create: Id[A] => MapState[A])(implicit idCodec: IdCodec[A]) : MapState[A] = for {
      id <- createGuid.map(guid => Id[A](guid))
      a <- create(id)
      _ <- set(id, a)
      _ <- StateT.modify[ErrorOr, StateData](sd => sd.copy(deltas = sd.deltas :+ StateDelta.Put(id, a)))
    } yield a

    def putListF[A](create: Id[List[A]] => MapState[List[A]])(implicit idCodec: IdCodec[A]): MapState[List[A]] = for {
      id <- createGuid.map(guid => Id[List[A]](guid))
      a <- create(id)
      _ <- set(id, a)(IdCodec.otList(idCodec))
//      _ <- StateT.modify[ErrorOr, StateData](sd => sd.copy(deltas = sd.deltas :+ StateDelta.Put(id, a)))
    } yield a

    def listOperation[A](id: Id[List[A]], op: Operation[A]): MapState[List[A]] = for {
      ds <- getDataState(id)
      cs <- getClientState(id)
      newCs = cs.withClientOp(op)._1.withServerConfirmation._1
      newData = newCs.local
      _ <- set[List[A]](id, newData)(ds.idCodec)
      _ <- StateT.modify[ErrorOr, StateData](sd =>
        sd.copy(
          otMap = sd.otMap.updated(id.guid, newCs),
          deltas = sd.deltas :+ StateDelta.Modify(id, ds.data, newData)
        )
      )
    } yield newData

  }
}
