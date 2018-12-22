package org.rebeam.tree

import cats.data.StateT
import cats.implicits._
import org.rebeam.tree.Guid._
import org.rebeam.tree.codec._

/**
  * Implementation of STM using a Map and PRandom as State
  */
object MapStateSTM {

  sealed trait Error {
    def message: String
  }

  case class IdNotFoundError[A](id: Id[A]) extends Error {
    def message: String = toString
  }

  case class DataRevision[A](data: A, revId: RevId[A], idCodec: IdCodec[A])

  case class StateData(
      nextGuid: Guid,
      map: Map[Guid, DataRevision[_]],
      random: PRandom,
      context: TransactionContext) extends IdCodecs {
    def getDataRevision[A](id: Id[A]): Option[DataRevision[A]] = map.get(id.guid).map(_.asInstanceOf[DataRevision[A]])
    def getData[A](id: Id[A]): Option[A] = getDataRevision(id).map(_.data)
    def updated[A](id: Id[A], a: A, revId: RevId[A])(implicit mCodecA: IdCodec[A]): StateData = {
      copy(map = map.updated(id.guid, DataRevision(a, revId, mCodecA)))
    }

    override def codecFor[A](id: Id[A]): Option[IdCodec[A]] =
      getDataRevision(id).map(_.idCodec)
  }

  def emptyState: StateData = StateData(
    Guid(SessionId(0), SessionTransactionId(0), TransactionClock(0)),
    Map.empty,
    PRandom(0),
    TransactionContext(Moment(0))
  )

  type ErrorOr[A] = Either[Error, A]
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

    private def set[A](id: Id[A], a: A)(implicit idCodec: IdCodec[A]): MapState[Unit] = for {
      revGuid <- createGuid
      _ <- StateT.modify[ErrorOr, StateData](_.updated(id, a, RevId(revGuid)))
    } yield ()

    def modifyF[A](id: Id[A], f: A => MapState[A]): MapState[A] = for {
      ds <- getDataState(id)
      newData <- f(ds.data)
      _ <- set[A](id, newData)(ds.idCodec)
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
            sd.copy(nextGuid = sd.nextGuid.copy(transactionClock = sd.nextGuid.transactionClock.next)),
            sd.nextGuid
          )
        )
      })

    def putF[A](create: Id[A] => MapState[A])(implicit idCodec: IdCodec[A]) : MapState[A] = for {
      id <- createGuid.map(guid => Id[A](guid))
      a <- create(id)
      _ <- set(id, a)
    } yield a

  }
}
