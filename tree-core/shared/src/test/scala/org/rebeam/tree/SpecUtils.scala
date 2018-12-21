package org.rebeam.tree

import cats.implicits._

import org.rebeam.tree.Guid._
import org.rebeam.tree.MapStateSTM._

object SpecUtils {

  case class MapDataSource(map: Map[Guid, Any]) extends DataSource {
    override def get[A](id: Id[A]): Option[A] = map.get(id.guid).map(_.asInstanceOf[A])

    def put[A](id: Id[A], a: A): MapDataSource =
      copy(map = map.updated(id.guid, a))
  }

  object MapDataSource {
    val empty: MapDataSource = MapDataSource(Map.empty)
  }

  def guid(sid: Long, stid: Long, tc: Long): Guid =
    Guid(SessionId(sid), SessionTransactionId(stid), TransactionClock(tc))

  def runS[A](s: S[A], stateData: StateData = emptyState): (StateData, A) = {
    val errorOrA = s.run(stateData)
    assert(errorOrA.isRight)
    errorOrA.right.get
  }

  def runView[A](s: DataSourceViewOps.S[A], stateData: DataSourceViewOps.StateData): (DataSourceViewOps.StateData, A) = {
    val errorOrA = s.run(stateData)
    assert(errorOrA.isRight)
    errorOrA.right.get
  }

  def failView[A](s: DataSourceViewOps.S[A], stateData: DataSourceViewOps.StateData): DataSourceViewOps.Error = {
    val errorOrA = s.run(stateData)
    assert(errorOrA.isLeft)
    errorOrA.left.get
  }
}
