package org.rebeam.tree

import org.rebeam.tree.ot.{CursorUpdate, OTList}

case class MapDataSource(data: Map[Guid, (Any, TransactionId)]) extends DataSource {

  override def get[A](id: Id[A]): Option[A] = getWithTransactionId(id).map(_._1)

  override def getWithTransactionId[A](id: Id[A]): Option[(A, TransactionId)] =
    data.get(id.guid).map(p => p.copy(_1 = p._1.asInstanceOf[A]))

  override def getTransactionIdFromGuid(guid: Guid): Option[TransactionId] =
    data.get(guid).map(_._2)

  //TODO
  override def getOTListCursorUpdate[A](list: OTList[A]): Option[CursorUpdate[A]] =
    None

  // Type-safe put method
  def put[A](id: Id[A], a: A, transactionId: TransactionId): MapDataSource =
    copy(data.updated(id.guid,(a, transactionId)))

}

object MapDataSource {
  val empty: MapDataSource = MapDataSource(Map.empty)
}