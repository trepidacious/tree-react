package org.rebeam.tree.ot

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
  * The state needed on each client to allow for operations to be applied optimistically (and immediately) locally,
  * but then transformed and sent appropriately based on updates to the server.
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
  * @tparam A           The type of element in edited list
  */
case class ClientState[A](server: ListRev[A], local: List[A], pendingOp: Option[Operation[A]], buffer: Option[Operation[A]]) {

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
      val opRev = OpRev(buffer.compose(op), server.rev)
      val newState = copy(
        pendingOp = Some(opRev.op),
        buffer = None,
        local = op(local)
      )
      (newState, Some(opRev))

    // We have a pending op already - we need to add the new op to the buffer and then keep waiting for a server update
    case Some(_) =>
      val newState = copy(
        buffer = Some(buffer.compose(op)),
        local = op(local)
      )
      (newState, None)

  }

  /**
    * Produce a new client state and optionally an OpRev to send to the server, based on the
    * server confirming the application of our pending operation
    * @return New client state and optional OpRev to send to the server
    */
  def withServerPendingConfirmation: (ClientState[A], Option[OpRev[A]]) = pendingOp match {
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
          pendingOp = buffer, buffer = None
        ),

        // Send any buffer against the new server revision
        buffer.map(b => OpRev(b, newServerState.rev))
      )

    case None => throw new RuntimeException("Server pending confirmation with no pending op")
  }

  /**
    * Produce a new client state based on the server sending a remote operation
    * @param op   The operation from the server
    * @return     New client state
    */
  def withServerRemoteOp(op: Operation[A]): ClientState[A] = {

    // We need to move the pending op (if any) to apply after the remote op,
    // treating it as a client-side operation
    val newPending = pendingOp.map(_.clientAfter(op))

    // Now we update the buffered op to be after the new server op AND after the
    // pending op.
    val newBuffer = buffer.map(b => b.clientAfter(op.serverAfterOptional(pendingOp)))

    val newServerState = server.withOp(op)

    // Optimistic local state is now the new server state, with the updated pending
    // op then the updated buffered op
    val newLocal = newBuffer(newPending(newServerState.a))

    // Update our state. Note we can't send our buffer until we receive a confirmation
    // and so clear the pending op
    copy(
      server = newServerState,
      local = newLocal,
      pendingOp = newPending,
      buffer = newBuffer
    )
  }

}

