import org.rebeam.tree.TransactionId
import org.rebeam.tree.ot._

//package org.rebeam.tree.ot
//
///**
//  * An Action contains the response to a client or server message,
//  * which always updates the client state, and optionally also
//  * requires an update to the client's document or the sending
//  * of a client message to the server.
//  * @tparam A     The type of element in the document list
//  */
//sealed trait Action[A] {
//  /**
//    * The new state of the client
//    */
//  val state: ClientState[A]
//}
//
//object Action {
//  /**
//    * Update client state, and send a message to the server with
//    * an operation requested by the client
//    * @param op     The operation to send to the server
//    * @param state  The new client state
//    * @tparam A     The type of element in the document list
//    */
//  case class Send[A](op: OpRev[A], state: ClientState[A]) extends Action[A]
//
//  /**
//    * Update client state, and apply an operation received from the server
//    * to the current client document
//    * @param op     The operation to apply to the client document
//    * @param state  The new client state
//    * @tparam A     The type of element in the document list
//    */
//  case class Apply[A](op: OpRev[A], state: ClientState[A]) extends Action[A]
//
//  /**
//    * Just update the client state
//    * @param state  The new client state
//    * @tparam A     The type of element in the document list
//    */
//  case class Shift[A](state: ClientState[A]) extends Action[A]
//}
//
//import Action._
//
//sealed trait ClientState[A] {
////
////  /**
////    * The document revision we are synchronised at
////    */
////  val rev: Int
////
////  /**
////    * Produce an Action that will update the client state with the
////    * results of an operation requested by the client (i.e. a local edit)
////    * @param op The client operation
////    * @return   Resulting Action
////    */
////  def applyClient(op: OpRev[A]): Action[A]
////  def applyServer(op: OpRev[A]): Action[A]
////}
////
////object ClientState {
////
////  /**
////    * Client is synchronised with server - it has had no client edits since the most
////    * recent update from the server (applyServer)
////    * @param rev  The document revision we are synchronised at
////    * @tparam A   The type of element in the document list
////    */
////  case class Synchronized[A](rev: Int) extends ClientState[A] {
////    def applyClient(op: OpRev[A]): Action[A] = {
////      val op2 = op.reparent(version)
////      Send(op2, AwaitingConfirm(op2, version))
////    }
////
////    def applyServer(op: OpRev[A]): Action[A] = Apply(op, Synchronized(op.version))
////  }
////
////  case class AwaitingConfirm[A](outstanding: OpRev[A], version: Int) extends ClientState[A] {
////    def applyClient(op: OpRev[A]): Action[A] =
////      Shift(AwaitingWithBuffer(outstanding, op.reparent(outstanding.version), version))
////
////    def applyServer(op: OpRev[A]): Action[A] = {
////      if (op.id == outstanding.id) {
////        Shift(Synchronized(op.version))
////      } else {
////        val pair = Transformer.transform(outstanding.delta, op.delta)
////        val (client, server) = (pair.clientOp, pair.serverOp)
////        val outstanding2 = outstanding.copy(delta = client)
////        Apply(op.copy(delta = server), AwaitingConfirm(outstanding2.reparent(op.version), op.version))
////      }
////    }
////  }
////
////  case class AwaitingWithBuffer[A](outstanding: OpRev[A], buffer: OpRev[A], version: Int) extends ClientState[A] {
////    def applyClient(op: OpRev[A]): Action[A] = {
////      val buffer2 = buffer.copy(id = op.id, version = buffer.version + 1, delta = Composer.compose(buffer.delta, op.delta))
////      Shift(AwaitingWithBuffer(outstanding, buffer2, version))
////    }
////
////    def applyServer(op: OpRev[A]): Action[A] = {
////      if (op.id == outstanding.id) {
////        Send(buffer, AwaitingConfirm(buffer, op.version))
////      } else {
////        val pair = Transformer.transform(outstanding.delta, op.delta)
////        val (client, server) = (pair.clientOp, pair.serverOp)
////        val outstanding2 = outstanding.copy(delta = client).reparent(op.version)
////
////        val pair2 = Transformer.transform(buffer.delta, server)
////        val (client2, server2) = (pair2.clientOp, pair2.serverOp)
////        val buffer2 = buffer.copy(delta = client2).reparent(outstanding2.version)
////
////        Apply(op.copy(delta = server2), AwaitingWithBuffer(outstanding2, buffer2, op.version))
////      }
////    }
////  }
//
//}
//
//

//Extension to cursors - keep a client rev id in the ClientState, completely separate to server rev id, and increment it each time
//client state is updated in any way, as well as keeping the data needed to transform a cursor on the previous client rev id
//to the current one. Cursors will initialise by just picking a cursor position against the first client rev they see (
//normally 0) and storing the cursor position and first client rev seen. Then each time they see a new client state they ask to be updated from the
//stored client rev - if this was the previous client rev it will succeed, if it fails (due to missing a client state in the sequence) they will just reset the
//cursor. This then works properly if each cursor sees each client rev (which should be the case) and resets
//cursor (with a warning?) if something unexpected happens and a client state is missed.
//In React the client rev and cursor position will be stored in component state, and the check will detect if something
//unexpected happens, and a component is not updated with each client state in sequence, as it should be.
//In future, we could provide for updates from older client revs by storing more history, if this is needed, e.g.
//if React starts skipping updates for some reason.
//The data stored in ClientState to allow transforming a cursor is just the final operation that got us from the previous
//client state to this one.

case class ServerState[A](a: List[A], rev: Rev)

case class ClientState[A](serverState: ServerState[A], localA: List[A], pendingOp: Option[Operation[A]], buffer: Option[Operation[A]]) {

  private def bufferWithOp(op: Operation[A]): Operation[A] = buffer.map(_.compose(op)).getOrElse(op)

  /**
    * Update the client state with a new client operation
    * @param op The operation
    * @return   The new state, and an OpRev to send to the server, if needed
    */
  def withClientOp(op: Operation[A]): (ClientState[A], Option[OpRev[A]]) = pendingOp match {

    // No pending operation - we can add the new op to the buffer and send the buffer immediately, against
    // the current server revision
    case None =>
      val opRev = OpRev(bufferWithOp(op), serverState.rev)
      val newState = copy(
        pendingOp = Some(opRev.op),
        buffer = None,
        localA = op(localA)
      )
      (newState, Some(opRev))

    // We have a pending op already - we need to add the new op to the buffer and then keep waiting for a server update
    case Some(_) =>
      val newState = copy(
        buffer = Some(bufferWithOp(op)),
        localA = op(localA)
      )
      (newState, None)

  }

  def withServerUpdate(tid: TransactionId, opRev: OpRev[A]): (ClientState[A], Option[OpRev[A]]) = pendingOp match {
    // If our pending operation is being applied
    case Some(PendingOp(_, pendingTid)) if pendingTid == tid =>
      // We need to rebase our buffer, by moving it before the pending buffer, then past the operation the server
      // just sent (our transformed
      val newState = copy(
        serverState = ServerState(opRev.op.apply(serverState.a), opRev.rev),
        pendingOp = None,
        buffer = None
      )


    // Someone else's op is being applied
    case _ =>


  }

}
