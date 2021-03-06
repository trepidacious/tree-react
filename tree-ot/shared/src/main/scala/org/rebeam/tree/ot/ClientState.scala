package org.rebeam.tree.ot

import org.rebeam.tree.ot.ServerMessage.{ServerConfirmation, ServerRemoteOp}

//Extension to cursors - keep a client rev id in the org.rebeam.tree.ot.ClientState, completely separate to server rev id, and increment it each time
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
//The data stored in org.rebeam.tree.ot.ClientState to allow transforming a cursor is just the final operation that got us from the previous
//client state to this one.

/**
  * A state of the list data, and associated revision
  * @param a    The list state
  * @param rev  The revision
  * @tparam A   The type of list element
  */
case class ListRev[A](a: List[A], rev: Rev) {
  /**
    * Produce a new ListRev by applying an operation and
    * incrementing the revision.
    * @param op   The operation to apply
    * @return     A new ListRev
    */
  def withOp(op: Operation[A]): ListRev[A] = ListRev(op.apply(a), rev.next)
}

/**
  * Represents an update to the local data state of the client, by applying an operation
  * @param op             The operation that was applied
  * @param ownOperation   True if the operation originally came from this client, false if it came from a remote client.
  * @tparam A             The type of list element
  */
case class LocalUpdate[A](op: Operation[A], ownOperation: Boolean)

/**
  * The data needed to update a cursor for a single update to the state of an OT list
  * @tparam A The type of data in the list
  */
trait CursorUpdate[A]{
  def clientRev: Int
  def previousLocalUpdate: Option[LocalUpdate[A]]
}

/**
  * The state needed on each client to allow for operations to be applied optimistically (and immediately) locally,
  * but then transformed and sent appropriately based on updates to the server.
  * @param priority     Our own priority as a client
  * @param server       The most recent known server state, as data and a revision
  * @param local        The current, optimistic state of the data locally, based on the server state with local edits
  *                     applied immediately.
  * @param pendingOp    Optional pending operation - this is Some(op) when op has been sent to the server to be applied
  *                     but we have not yet received a confirmation indicating where it was authoritatively applied.
  *                     Note this is always transformed so that it can be applied on top of the current server state.
  *                     This means that when a remote operation (from another client) is received, pendingOp is updated
  *                     to be applied after the remote operation. This means that when confirmation is received, the
  *                     pendingOp is ready to be applied directly. When there is no pending operation, this is None.
  * @param buffer       Optional operation containing all the edits that have been made subsequently to the pendingOp,
  *                     combined together into a single operation. This is (slightly counterintuitively)
  * @param clientRev    The client revision. This changes every time the client state changes. The client state stores
  *                     data on the previous state change to allow updating from the previous clientRev to the
  *                     current one, and so when a cursor is updated we must check it was up to date with the
  *                     previous clientRev to get a valid result - otherwise it must be reset.
  * @param previousLocalUpdate
  *                     The previous update applied to the client local state for clientRev - 1 to produce
  *                     the current local state.
  *                     This is None for clientRev 0, since we have no previous operation. It is also None after
  *                     updating for a ServerConfirmation, since this does not affect the local state.
  *                     Updated for each clientRev, and used for example to update a cursor against ClientRev - 1 to
  *                     one against clientRev.
  * @tparam A           The type of element in edited list
  */
case class ClientState[A](priority: Long, server: ListRev[A], local: List[A], pendingOp: Option[Operation[A]] = None, buffer: Option[Operation[A]] = None, clientRev: Int = 0, previousLocalUpdate: Option[LocalUpdate[A]] = None) extends CursorUpdate[A] {

  /**
    * Allow us to apply and compose an optional operation - None is treated as an empty operation (does nothing)
    */
  private implicit class OptionalOperation(op: Option[Operation[A]]) {
    def apply(l: List[A]): List[A] = op match {
      case Some(o) => o(l)
      case None => l
    }
    def compose(newOp: Operation[A]): Operation[A] = op.map(_.compose(newOp)).getOrElse(newOp)
  }

  /**
    * Update the client state with a new client operation
    * @param op The operation
    * @return   The new state, and an OpRev to send to the server, if needed
    */
  def withClientOp(op: Operation[A]): (ClientState[A], Option[OpRev[A]]) = pendingOp match {

    // No pending operation - we can add the new op to the buffer and send the buffer immediately, against
    // the current server revision
    case None =>
      val opRev = OpRev(buffer.compose(op), priority, server.rev)
      val newState = copy(
        pendingOp = Some(opRev.op),
        buffer = None,
        local = op(local),
        clientRev = clientRev + 1,
        previousLocalUpdate = Some(LocalUpdate(op, ownOperation = true))
      )
      (newState, Some(opRev))

    // We have a pending op already - we need to add the new op to the buffer and then keep waiting for a server update
    case Some(_) =>
      val newState = copy(
        buffer = Some(buffer.compose(op)),
        local = op(local),
        clientRev = clientRev + 1,
        previousLocalUpdate = Some(LocalUpdate(op, ownOperation = true))
      )
      (newState, None)

  }

  def withServerMessage(msg: ServerMessage[A]): (ClientState[A], Option[OpRev[A]]) = msg match {
    case ServerConfirmation() => withServerConfirmation
    case ServerRemoteOp(op) => (withServerRemoteOp(op), None)
  }

  /**
    * Produce a new client state and optionally an OpRev to send to the server, based on the
    * server confirming the application of our pending operation
    * @return New client state and optional OpRev to send to the server
    */
  def withServerConfirmation: (ClientState[A], Option[OpRev[A]]) = pendingOp match {
    case Some(op) =>

      // Server has confirmed our pending op. We have been keeping it up to date against server
      // operations, so we can just apply it directly and increment the server state to get the
      // new server state.
      val newServerState = server.withOp(op)

      // Note there is no need to adjust the buffer or localA - they were already up to date anticipating the pending op
      // We send the buffer if we have one, so we now have no buffer in either case
      (
        copy(
          server = newServerState,
          // We send any buffer to the client, and it becomes our pending op
          pendingOp = buffer, buffer = None,
          clientRev = clientRev + 1,
          previousLocalUpdate = None
        ),

        // Send any buffer against the new server revision
        buffer.map(b => OpRev(b, priority, newServerState.rev))
      )

    case None => throw new RuntimeException("Server pending confirmation with no pending op")
  }

  /**
    * Produce a new client state based on the server sending a remote operation
    *
    * @param pop   The operation and priority from the server
    * @return     New client state
    */
  def withServerRemoteOp(pop: PriorityOperation[A]): ClientState[A] = {

    val op = pop.op

    // p indicates whether the client operation is higher priority than the remote
    // operation, and is passed to `after` as a tie-breaker.
    // Therefore we use `p` where we are calling `after` on an operation of this client (pending or buffer),
    // and `!p` where we are calling after on the remote operation (op).
    val p = priority > pop.priority

    // We need to move the pending op (if any) to apply after the remote op,
    // treating it as a client-side operation
    val newPending = pendingOp.map(_.after(p, op))

    // Now we update the buffered op to be after the new server op AND after the
    // pending op.
    val opAfterPending = op.afterOptional(!p, pendingOp)
    val newBuffer = buffer.map(b => b.after(p, opAfterPending))

    val newServerState = server.withOp(op)

    // Optimistic local state is now the new server state, with the updated pending
    // op then the updated buffered op
    val newLocal = newBuffer(newPending(newServerState.a))

    // Produce an operation that takes previous local state and produces
    // the new local state. This is the previousOp
    val newPreviousOp = opAfterPending.afterOptional(!p, buffer)

    // Update our state. Note we can't send our buffer until we receive a confirmation
    // and so clear the pending op
    copy(
      server = newServerState,
      local = newLocal,
      pendingOp = newPending,
      buffer = newBuffer,
      clientRev = clientRev + 1,
      previousLocalUpdate = Some(LocalUpdate(newPreviousOp, ownOperation = false))
    )
  }

}
