package org.rebeam.tree

//import org.rebeam.tree.ot.{CursorUpdate, OTList}

trait DataSource {
  def get[A](id: Id[A]): Option[A]
  def getWithTransactionId[A](id: Id[A]): Option[(A, TransactionId)]
  def getTransactionIdFromGuid(guid: Guid): Option[TransactionId]
//  def getOTListCursorUpdate[A](list: OTList[A]): Option[CursorUpdate[A]]
}