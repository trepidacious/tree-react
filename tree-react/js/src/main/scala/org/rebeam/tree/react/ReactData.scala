package org.rebeam.tree.react

import japgolly.scalajs.react.{Callback, React}
import japgolly.scalajs.react.React.Context
import org.log4s.getLogger
import org.rebeam.tree._
//import org.rebeam.tree.ot.{CursorUpdate, OTList}

trait ReactTransactor {
  def transact(t: Transaction): Callback
}

trait ReactData extends DataSource with ReactTransactor

object ReactData {

  private val logger = getLogger

  private val emptyData: ReactData = new ReactData {
    override def get[A](id: Id[A]): Option[A] = None
    override def getWithRev[A](id: Id[A]): Option[(A, TransactionId)] = None
    override def revGuid(guid: Guid): Option[TransactionId] = None
//    override def getOTListCursorUpdate[A](list: OTList[A]): Option[CursorUpdate[A]] = None
    def transact(t: Transaction): Callback = Callback{logger.warn(s"ReactData.empty discards transaction $t")}
  }

  private val emptyTransactor: ReactTransactor = t => Callback.warn(s"ReactData.emptyTransactor discards transaction: $t")

  private val defaultContext: Context[ReactData] = React.createContext(emptyData)

  private val defaultTransactorContext: Context[ReactTransactor] = React.createContext(emptyTransactor)

  // Move to own class, move defaultContexts to companion as just default
  case class ReactDataContexts(data: Context[ReactData], transactor: Context[ReactTransactor])

  val defaultContexts: ReactDataContexts = ReactDataContexts(defaultContext, defaultTransactorContext)

}