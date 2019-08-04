package org.rebeam.tree.slinkify

import org.log4s.getLogger
import org.rebeam.tree._
import _root_.slinky.core.facade._
//import org.rebeam.tree.ot.{CursorUpdate, OTList}

import Syntax._

trait ReactTransactor {
  def transact(t: Transaction): Callback
}

trait ReactData extends DataSource with ReactTransactor

object ReactData {

  private val logger = getLogger

  private val emptyData: ReactData = new ReactData {
    override def get[A](id: Id[A]): Option[A] = None
    override def getWithTransactionId[A](id: Id[A]): Option[(A, TransactionId)] = None
    override def getTransactionIdFromGuid(guid: Guid): Option[TransactionId] = None
//    override def getOTListCursorUpdate[A](list: OTList[A]): Option[CursorUpdate[A]] = None
    def transact(t: Transaction): Callback = Callback{logger.warn(s"ReactData.empty discards transaction $t")}
    override def toString: String = "ReactData.emptyData"
  }

  private val emptyTransactor: ReactTransactor = t => Callback.warn(s"ReactData.emptyTransactor discards transaction: $t")

  private val defaultContext: ReactContext[ReactData] = React.createContext(emptyData)

  private val defaultTransactorContext: ReactContext[ReactTransactor] = React.createContext(emptyTransactor)

  // Move to own class, move defaultContexts to companion as just default
  case class ReactDataContexts(data: ReactContext[ReactData], transactor: ReactContext[ReactTransactor])

  val defaultContexts: ReactDataContexts = ReactDataContexts(defaultContext, defaultTransactorContext)

}