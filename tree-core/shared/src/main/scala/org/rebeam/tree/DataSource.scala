package org.rebeam.tree

//import org.rebeam.tree.ot.{CursorUpdate, OTList}

trait DataSource {
  def get[A](id: Id[A]): Option[A]
  def getWithRev[A](id: Id[A]): Option[(A, RevId[A])]
  def revGuid(guid: Guid): Option[Guid]
//  def getOTListCursorUpdate[A](list: OTList[A]): Option[CursorUpdate[A]]
}