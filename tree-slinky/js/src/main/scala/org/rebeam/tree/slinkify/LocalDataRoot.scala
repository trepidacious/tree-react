package org.rebeam.tree.slinkify

import cats.implicits._
import org.log4s._
import org.rebeam.tree.MapStateSTM._
import org.rebeam.tree._
import org.rebeam.tree.codec.TransactionCodec
import slinky.core._
import slinky.core.facade.Hooks._
import slinky.core.facade.ReactElement
//import slinky.readwrite.{Reader, Writer}
//import org.rebeam.tree.ot.{CursorUpdate, OTList}
import ReactData.ReactDataContexts
//import scalajs.js

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

    override def getWithRev[A](id: Id[A]): Option[(A, RevId[A])] = sd.getWithRev(id)

    //    override def getOTListCursorUpdate[A](list: OTList[A]): Option[CursorUpdate[A]] = sd.getOTListCursorUpdate(list)

    override def revGuid(guid: Guid): Option[Guid] = sd.revGuid(guid)

    override def transact(t: Transaction): Callback = tx.transact(t)

    override def toString: String = s"LocalReactData(${sd.map.size} entries)"
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

  def component[A, I](r: (A, I) => ReactElement,
              indexer: Indexer[I],
              initialTransaction: Transaction = Transaction.doNothing,
              contexts: ReactDataContexts = ReactData.defaultContexts,
              )(implicit transactionCodec: TransactionCodec,
                reusability: Reusability[A]
  ): FunctionalComponent[A] = {

    slinky.core.FunctionalComponent[A] {
      val (state, setState) = useState[S[I]]{
        val empty = S(emptyState, indexer.initial)
        runTransaction(empty, initialTransaction, indexer).getOrElse(empty)
      }

      // Transactor that will run log transactions to demonstrate encoding, then run them against our local STM,
      // then either log a warning on transaction failure or set the resulting new STM into our state for children
      // to render.
      val tx = new ReactTransactor {
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

      // TODO make there be one tx and txContext per component instance, rather than per-render
      val txContext = contexts.transactor.Provider(value = tx)

      props => {
        txContext(
          contexts.data.Provider(value = LocalReactData(state.sd, tx))(
            r(props, state.index)
          )
        )
      }
    }
  }

//  def component[A, I](
//                       r: (A, I) => ReactElement,
//                       indexer: Indexer[I],
//                       initialTransaction: Transaction = Transaction.doNothing,
//                       contexts: ReactDataContexts = ReactData.defaultContexts,
//                     )
//                     (implicit
//                      transactionCodec: TransactionCodec,
//                      reusability: Reusability[A]
//                     ): BasicFunctionalComponent[A] = {
//
//    //FIXME This doesn't seem right - missing these out gives:
//    //`could not find implicit value for parameter sr: slinky.core.StateReaderProvider`
//    //Inspecting code for StateReaderProvider seems to indicate that instances are provided via a macro,
//    //and are null in production mode, so perhaps this is valid?
//    implicit val sr = null.asInstanceOf[StateReaderProvider]
//    implicit val sw = null.asInstanceOf[StateWriterProvider]
//    // Unfortunately having using null gives
//    // `An undefined behavior was detected: [object Object] is not an instance of org.rebeam.tree.slinkify.LocalDataRoot$C$1$`
//    // As does using the reader/writer below (these do seem to fix the lack of StateReaderProvider though - the
//    // Reader/Writer seem to be used to produce the required providers.
//    // This might be related to https://github.com/shadaj/slinky/issues/197 ? This says that having a ComponentWrapper
//    // that isn't an object might cause problems - presumably the same applies for the @react macro, and having a class
//    // in a def is probably even worse :)
//
//
////    implicit val sr = new Reader[S[I]] {
////      protected def forceRead(o : scala.scalajs.js.Object) : S[I] =
////        o.asInstanceOf[js.Dynamic].scalaState.asInstanceOf[S[I]]
////    }
////    implicit val sw = new Writer[S[I]] {
////      def write(p : S[I]) : scala.scalajs.js.Object = js.Dynamic.literal(scalaState = p.asInstanceOf[js.Any])
////    }
//
////    object C extends ComponentWrapper {
////      type Props = A
////      type State = S[I]
////
////      class Def(jsProps: js.Object) extends Definition(jsProps) {
////        // Start from empty STM and initial indexer,
////        // with initial transaction applied if successful
////        override def initialState: S[I] = {
////          val empty = S(emptyState, indexer.initial)
////          runTransaction(empty, initialTransaction, indexer).getOrElse(empty)
////        }
////
////        // Transactor that will run log transactions to demonstrate encoding, then run them against our local STM,
////        // then either log a warning on transaction failure or set the resulting new STM into our state for children
////        // to render.
////        private val tx = new ReactTransactor {
////          override def transact(t: Transaction): Callback = Callback {
////            logger.info(
////              transactionCodec
////                .encoder(t)(state.sd)
////                .map(_.toString).getOrElse(s"Could not encode transaction $t")
////            )
////
////            // Run the transaction
////            val s = runTransaction(state, t, indexer)
////
////            // Deal with result of transaction
////            s match {
////              // Error - we leave state alone, but log error
////              case Left(error) => logger.warn(s"Failed transaction: $error")
////              // We have a new state
////              case Right(newState) => setState(newState) // >> Callback{logger.info(s"Applied transaction: $t")}
////            }
////          }
////        }
////
////        override def shouldComponentUpdate(nextProps: Props, nextState: State): Boolean =
////          (nextState ne state) || !reusability.test(props, nextProps)
////
////        // Note we cache the Provider, since tx does not change.
////        // This is so that React will receive the same wrapped JS value, and not
////        // trigger an update of everything using this context on each render.
////        // This is not necessary for the LocalReactData context provider since
////        // this will change whenever a transaction updates the STM.
////        private val txContext = contexts.transactor.Provider(value = tx)
////
////        override def render(): ReactElement = {
////          txContext(
////            contexts.data.Provider(value = LocalReactData(state.sd, tx))(
////              r(props, state.index)
////            )
////          )
////        }
////      }
////    }
//
//
//
//    @react class C extends Component {
//      type Props = A
//      type State = S[I]
//
//      // Start from empty STM and initial indexer,
//      // with initial transaction applied if successful
//      override def initialState: S[I] = {
//        val empty = S(emptyState, indexer.initial)
//        runTransaction(empty, initialTransaction, indexer).getOrElse(empty)
//      }
//
//      // Transactor that will run log transactions to demonstrate encoding, then run them against our local STM,
//      // then either log a warning on transaction failure or set the resulting new STM into our state for children
//      // to render.
//      private val tx = new ReactTransactor {
//        override def transact(t: Transaction): Callback = Callback {
//          logger.info(
//            transactionCodec
//              .encoder(t)(state.sd)
//              .map(_.toString).getOrElse(s"Could not encode transaction $t")
//          )
//
//          // Run the transaction
//          val s = runTransaction(state, t, indexer)
//
//          // Deal with result of transaction
//          s match {
//            // Error - we leave state alone, but log error
//            case Left(error) => logger.warn(s"Failed transaction: $error")
//            // We have a new state
//            case Right(newState) => setState(newState) // >> Callback{logger.info(s"Applied transaction: $t")}
//          }
//        }
//      }
//
//      override def shouldComponentUpdate(nextProps: Props, nextState: State): Boolean =
//        (nextState ne state) || !reusability.test(props, nextProps)
//
//      // Note we cache the Provider, since tx does not change.
//      // This is so that React will receive the same wrapped JS value, and not
//      // trigger an update of everything using this context on each render.
//      // This is not necessary for the LocalReactData context provider since
//      // this will change whenever a transaction updates the STM.
//      private val txContext = contexts.transactor.Provider(value = tx)
//
//      override def render(): ReactElement = {
//        txContext(
//          contexts.data.Provider(value = LocalReactData(state.sd, tx))(
//            r(props, state.index)
//          )
//        )
//      }
//    }
//
//    a: A => C(a)
//  }

}