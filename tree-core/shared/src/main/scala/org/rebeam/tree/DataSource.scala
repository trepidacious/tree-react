package org.rebeam.tree

import org.rebeam.tree.ot.CursorUpdate

trait DataSource {
  def get[A](id: Id[A]): Option[A]
  def getWithRev[A](id: Id[A]): Option[(A, RevId[A])]
  def revGuid(guid: Guid): Option[Guid]
  def getList[A](id: Id[List[A]]): Option[(List[A], CursorUpdate[A])]
}