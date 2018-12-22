package org.rebeam.tree

trait DataSource {
  def get[A](id: Id[A]): Option[A]
  def getWithRev[A](id: Id[A]): Option[(A, RevId[A])]
}