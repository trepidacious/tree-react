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

        val (state, setState) = useState[S[I]]{
          val empty = S(emptyState, indexer.initial)
          runTransaction(empty, initialTransaction, indexer).getOrElse(empty)
        }

        val tx = //useMemo (
          // Transactor that will run log transactions to demonstrate encoding, then run them against our local STM,
          // then either log a warning on transaction failure or set the resulting new STM into our state for children
          // to render.
          //() => {
            //println("New ReactTransactor")
            new ReactTransactor {
              override def transact(t: Transaction): Callback = Callback {
                logger.info(
                  transactionCodec
                    .encoder(t)(state.sd)
                    .map(_.toString).getOrElse(s"Could not encode transaction $t")
                )

                // Run the transaction
                val s = runTransaction(state, t, indexer)

                // Deal with result of transaction
                s match {
                  // Error - we leave state alone, but log error
                  case Left(error) => logger.warn(s"Failed transaction: $error")
                  // We have a new state
                  case Right(newState) => setState(newState) // >> Callback{logger.info(s"Applied transaction: $t")}
                }
              }
            }
          //},
          //List(state, setState)
        //)

        val txContext = //useMemo (
          //() =>
            contexts.transactor.Provider(value = tx)
          //, Nil
        //)

        txContext(
          contexts.data.Provider(value = LocalReactData(state.sd, tx))(
            {
              println("Providing " + state.sd)
              r(props, state.index)
            }
          )
        )
      }
    }
  }


}