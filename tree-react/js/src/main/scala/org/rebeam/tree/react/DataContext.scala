package org.rebeam.tree.react

import japgolly.scalajs.react.React.Context
import japgolly.scalajs.react._
import org.rebeam.tree._
import org.log4s._

object DataContext {

  private val logger = getLogger

  private val emptyDataSource = new DataSource {
    override def get[A](id: Id[A]): Option[A] = None
    override def getWithRev[A](id: Id[A]): Option[(A, RevId[A])] = None
    override def revGuid(guid: Guid): Option[Guid] = None
  }

  val default: Context[DataSource] = React.createContext(emptyDataSource)

}
