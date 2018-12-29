package org.rebeam.tree.react

import japgolly.scalajs.react.{Callback, React}
import japgolly.scalajs.react.React.Context
import org.log4s.getLogger
import org.rebeam.tree._

trait ReactTransactor {
  def transact(t: Transaction): Callback
}

trait ReactData extends DataSource with ReactTransactor

object ReactData {

  private val logger = getLogger

  val empty: ReactData = new ReactData {
    override def get[A](id: Id[A]): Option[A] = None
    override def getWithRev[A](id: Id[A]): Option[(A, RevId[A])] = None
    override def revGuid(guid: Guid): Option[Guid] = None
    def transact(t: Transaction): Callback = Callback{logger.warn(s"ReactData.empty discards transaction $t")}
  }

  type DataContext = Context[ReactData]

  val defaultContext: Context[ReactData] = React.createContext(empty)

}