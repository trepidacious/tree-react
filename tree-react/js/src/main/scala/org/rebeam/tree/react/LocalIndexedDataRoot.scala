package org.rebeam.tree.react

import cats.implicits._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.vdom.html_<^._
import org.log4s._
import org.rebeam.tree.MapStateSTM._
import org.rebeam.tree._
import org.rebeam.tree.react.ReactData.DataContext

object LocalIndexedDataRoot {

  trait Indexer[I] {
    def initial: I
    def updated(index: I, deltas: Seq[StateDelta[_]]): I
  }

  private val logger = getLogger

  case class State[I](sd: StateData, index: I)

  case class LocalReactData(sd: StateData, tx: ReactTransactor) extends ReactData {
    override def get[A](id: Id[A]): Option[A] = sd.get(id)
    override def getWithRev[A](id: Id[A]): Option[(A, RevId[A])] = sd.getWithRev(id)
    override def revGuid(guid: Guid): Option[Guid] = sd.revGuid(guid)
    override def transact(t: Transaction): Callback = tx.transact(t)
  }

  //NOTE: This is not pure - gets the time for the transaction
  def runTransaction[I](state: State[I], t: Transaction, indexer: Indexer[I]): ErrorOr[State[I]] = {
    // Update the time to now
    val sdWithTime = state.sd.copy(context = TransactionContext(Moment(System.currentTimeMillis)))

    // Run the transaction on stateWithTime
    val sdNew = t[MapState].run(sdWithTime)

    // Map to a new State, updating the StateData to next transaction, and the indexer with deltas
    sdNew.map{
      case (newStateData, _) =>
        state.copy(sd = newStateData.nextTransaction, index = indexer.updated(state.index, newStateData.deltas))
    }

  }

  class Backend[A, I](bs: BackendScope[A, State[I]], r: (A, I) => VdomElement, dataContext: DataContext, indexer: Indexer[I]) {

    private val tx = new ReactTransactor {
      override def transact(t: Transaction): Callback = {
        for {
          // Get state from after last transaction
          state <- bs.state

          // Run the transaction Update the time to now
          s = runTransaction(state, t, indexer)

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

    def render(p: A, s: State[I]): VdomElement = {
      dataContext.provide(LocalReactData(s.sd, tx))(r(p, s.index))
    }
  }

  def component[A: Reusability, I](
    r: (A, I) => VdomElement)(
    indexer: Indexer[I],
    initialTransaction: Transaction = Transaction.doNothing,
    dataContext: DataContext = ReactData.defaultContext,
  ) =
    ScalaComponent.builder[A]("LocalDataRoot")
      .initialState {
        val initialState = State(emptyState, indexer.initial)
        runTransaction(initialState, initialTransaction, indexer).getOrElse(initialState)
      }
      .backend(scope => new Backend[A, I](scope, r, dataContext, indexer))
      .render(s => s.backend.render(s.props, s.state))
      .shouldComponentUpdatePure(
        s => (s.nextState ne s.currentState) ||
          !implicitly[Reusability[A]].test(s.currentProps, s.nextProps)
      )
      .build

}
