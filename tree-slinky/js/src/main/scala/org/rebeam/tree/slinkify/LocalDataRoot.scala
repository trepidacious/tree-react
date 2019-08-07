package org.rebeam.tree.slinkify

import cats.implicits._
import org.log4s._
import org.rebeam.tree.MapStateSTM._
import org.rebeam.tree._
import org.rebeam.tree.codec.TransactionCodec
import slinky.core._
import slinky.core.facade.Hooks._
import slinky.core.facade.ReactElement
//import org.rebeam.tree.ot.{CursorUpdate, OTList}
import ReactData.ReactDataContexts

import Syntax._

object LocalDataRoot {

  trait Indexer[I] {
    def initial: I

    def updated(index: I, deltas: Seq[StateDelta[_]]): I
  }

  private val logger = getLogger

  case class S[I](sd: StateData, index: I)

  private case class LocalReactData(sd: StateData, tx: ReactTransactor) extends ReactData {
    override def get[A](id: Id[A]): Option[A] = sd.get(id)

    override def getWithTransactionId[A](id: Id[A]): Option[(A, TransactionId)] = sd.getWithTransactionId(id)

    //    override def getOTListCursorUpdate[A](list: OTList[A]): Option[CursorUpdate[A]] = sd.getOTListCursorUpdate(list)

    override def getTransactionIdFromGuid(guid: Guid): Option[TransactionId] = sd.getTransactionIdFromGuid(guid)

    override def transact(t: Transaction): Callback = tx.transact(t)

    override def toString: String = s"LocalReactData($sd)"
  }

  //NOTE: This is not pure - gets the time for the transaction
  private def runTransaction[I](state: S[I], t: Transaction, indexer: Indexer[I]): ErrorOr[S[I]] = {
    // Update the context - use current time and transactionId based on the nextGuid (which will be used to run the transaction)
    val sdWithContext = state.sd.copy(
      context = TransactionContext(
        Moment(System.currentTimeMillis),
        state.sd.nextGuid.transactionId
      )
    )

    // Run the transaction on sdWithContext
    val sdNew = t[MapState].run(sdWithContext)

    // Map to a new State, updating the StateData to next transaction, and the indexer with deltas
    sdNew.map {
      case (newStateData, _) =>
        state.copy(sd = newStateData.nextTransaction, index = indexer.updated(state.index, newStateData.deltas))
    }
  }

  def apply[A, I](r: (A, I) => ReactElement,
              indexer: Indexer[I],
              initialTransaction: Transaction = Transaction.doNothing,
              contexts: ReactDataContexts = ReactData.defaultContexts,
              )(implicit transactionCodec: TransactionCodec,
                reusability: Reusability[A]
  ): FunctionalComponent[A] = {

    FunctionalComponent[A] {

      props => {

        // We only use the
        val (state, setState) = useState[S[I]]{
          val empty = S(emptyState, indexer.initial)
          // TODO: Note that if the initial transaction fails we currently just leave the STM empty.
          runTransaction(empty, initialTransaction, indexer).getOrElse(empty)
        }

        // We useMemo to hold on to a single ReactTransactor instance. This only uses the setState function, which is
        // guaranteed stable - it does not change over the lifetime of a component.
        // Details are here:
        // https://reactjs.org/docs/hooks-faq.html#what-can-i-do-if-my-effect-dependencies-change-too-often
        val tx = useMemo (() => {
//          println(">>>>>>>>>>>>>>>>>>>>> New ReactTransactor!")
          new ReactTransactor {
            override def transact(t: Transaction): Callback = Callback {
              setState((currentState: S[I]) => {
                logger.info(
                  transactionCodec
                    .encoder(t)(currentState.sd)
                    .map(_.toString).getOrElse(s"Could not encode transaction $t")
                )

                // Run the transaction
                val s = runTransaction(currentState, t, indexer)

                // Deal with result of transaction
                s match {
                  // Error - we leave state alone, but log error
                  case Left(error) => {
                    logger.warn(s"Failed transaction: $error")
                    currentState
                  }
                  // We have a new state
                  case Right(newState) => newState // >> Callback{logger.info(s"Applied transaction: $t")}
                }
              })
            }
          }
        },
        Nil)

        // Now we can always provide the same value (by reference equality) to this Provider. This prevents
        // unnecessary renders of ViewPC, ViewPC2, ViewPT and any other components that just use this context.
        // Oddly, useMemo seems to upset slinky, which might be worth looking into in itself.
        val txContext = contexts.transactor.Provider(value = tx)

        txContext(
          // We don't memoise this provider or the LocalReactData, since it needs to change on every state
          // change anyway.
          contexts.data.Provider(value = LocalReactData(state.sd, tx))(
            // TODO according to https://frontarm.com/james-k-nelson/react-context-performance/
            // we should accept a children prop rather than a render prop, so that children can be identical
            // between renders. This would require us to remove the props and index, which should be fine for
            // most uses?
            r(props, state.index)
          )
        )
      }
    }
  }


}