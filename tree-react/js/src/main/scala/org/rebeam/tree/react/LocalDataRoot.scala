package org.rebeam.tree.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import org.rebeam.tree._
import org.rebeam.tree.MapStateSTM._
import japgolly.scalajs.react.vdom.html_<^._
import org.log4s._
import org.rebeam.tree.react.ReactData.DataContext

import cats.implicits._

object LocalDataRoot {

  private val logger = getLogger

  case class LocalReactData(sd: StateData, tx: ReactTransactor) extends ReactData {
    override def get[A](id: Id[A]): Option[A] = sd.get(id)
    override def getWithRev[A](id: Id[A]): Option[(A, RevId[A])] = sd.getWithRev(id)
    override def revGuid(guid: Guid): Option[Guid] = sd.revGuid(guid)
    override def transact(t: Transaction): Callback = tx.transact(t)
  }

  //NOTE: This is not pure - gets the time for the transaction
  def runTransaction(state: StateData, t: Transaction): ErrorOr[StateData] = {
    // Update the time to now
    val stateWithTime = state.copy(
      context = TransactionContext(Moment(System.currentTimeMillis))
    )

    // Run the transaction on stateWithTime
    val s = t[MapState].run(stateWithTime)

    s.map{
      // The new state, which needs to have nextGuid ready for the next transaction
      case (newState, _) => newState.nextTransaction
    }
  }

  class Backend[A](bs: BackendScope[A, StateData], r: A => VdomElement, dataContext: DataContext) {

    private val tx = new ReactTransactor {
      override def transact(t: Transaction): Callback = {
        for {
          // Get state from after last transaction
          state <- bs.state

          // Run the transaction Update the time to now
          s = runTransaction(state, t)

          // Deal with result of transaction
          _ <- s match {
            // Error - we leave state alone, but log error
            case Left(error) => Callback{logger.warn(s"Failed transaction: $error")}
            // We have a new state
            case Right(newState) => bs.setState(newState)
          }
        } yield ()
      }
    }

    def render(p: A, s: StateData): VdomElement = {
      dataContext.provide(LocalReactData(s, tx))(r(p))
    }
  }

  def component[A: Reusability](
    r: A => VdomElement)(
    initialTransaction: Transaction = Transaction.doNothing,
    dataContext: DataContext = ReactData.defaultContext,
  ) =
    ScalaComponent.builder[A]("LocalDataRoot")
      .initialState(
        runTransaction(emptyState, initialTransaction).getOrElse(emptyState)
      )
      .backend(scope => new Backend[A](scope, r, dataContext))
      .render(s => s.backend.render(s.props, s.state))
      .shouldComponentUpdatePure(
        s => (s.nextState ne s.currentState) ||
          !implicitly[Reusability[A]].test(s.currentProps, s.nextProps)
      )
      .build

}
