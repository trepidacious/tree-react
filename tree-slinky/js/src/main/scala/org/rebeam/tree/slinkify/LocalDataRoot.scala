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

        // The following approach to accessing the "current" state from the ReactTransactor seems to match this:
        // https://reactjs.org/docs/hooks-faq.html#why-am-i-seeing-stale-props-or-state-inside-my-function
        // The ReactTransactor is equivalent to "some asynchronous callback" as described in that FAQ.
        // There is a similar approach in a different use case here: https://github.com/facebook/react/issues/16091
        // TODO: We could factor out the useState and useRef to useCurrentState?

        // Our state contains the complete STM, initialised with the initialTransaction if possible
        // Note that this will return a new actual state on every call, so we will use it in a ref below.
        val state = useState[S[I]]{
          val empty = S(emptyState, indexer.initial)
          // TODO: Note that if the initial transaction fails we currently just leave the STM empty.
          runTransaction(empty, initialTransaction, indexer).getOrElse(empty)
        }

        // We use a reference to give a stable point to access state, so we can memoize tx and avoid an update
        // to all ReactTransactor users whenever the state changes
        // We update the reference in an effect since it should not be updated by the render itself. This means
        // that stateRef is only updated when a render commits, which should make this work with concurrent rendering.
        val stateRef = useRef(state)
        useEffect(
          () => stateRef.current = state,
          List(state)   // Update ref only when state tuple changes (although this is probably the case for most
                        // renders, it might not be for e.g. concurrent rendering?)
        )

        // Finally, useMemo to keep hold of a single ReactTransactor, tx. Since this uses the stateRef, it will always
        // use the current state value and setter from useState.
        val tx = useMemo (
          // Transactor that will run log transactions to demonstrate encoding, then run them against our local STM,
          // then either log a warning on transaction failure or set the resulting new STM into our state for children
          // to render.
          () => {
            new ReactTransactor {
              override def transact(t: Transaction): Callback = Callback {
                logger.info(
                  transactionCodec
                    .encoder(t)(stateRef.current._1.sd)
                    .map(_.toString).getOrElse(s"Could not encode transaction $t")
                )

                // Run the transaction
                val s = runTransaction(stateRef.current._1, t, indexer)

                // Deal with result of transaction
                s match {
                  // Error - we leave state alone, but log error
                  case Left(error) => logger.warn(s"Failed transaction: $error")
                  // We have a new state
                  case Right(newState) => stateRef.current._2(newState) // >> Callback{logger.info(s"Applied transaction: $t")}
                }
              }
            }
          },
          List(stateRef)  // In case we get a new ref from useRef (this probably doesn't happen)
        )

        // Now we can always provide the same value (by reference equality) to this Provider. This prevents
        // unnecessary renders of ViewPC, ViewPC2, ViewPT and any other components that just use this context.
        // Oddly, useMemo seems to upset slinky, which might be worth looking into in itself.
        val txContext = contexts.transactor.Provider(value = tx)

        txContext(
          // We don't memoise this provider or the LocalReactData, since it needs to change on every state
          // change anyway.
          contexts.data.Provider(value = LocalReactData(state._1.sd, tx))(
            // TODO according to https://frontarm.com/james-k-nelson/react-context-performance/
            // we should accept a children prop rather than a render prop, so that children can be identical
            // between renders. This would require us to remove the props and index, which should be fine for
            // most uses?
            r(props, state._1.index)
          )
        )
      }
    }
  }


}