package org.rebeam.tree.ot

/**
  * The state of a server handling operations on a list of elements.
  * State starts from an empty list, and an empty history.
  * history(0) produces revision 0 of the list when applied. There
  *
  * @tparam A       The type of element in the list
  * @param list     The current state of the list, after all operations have been applied
  *                 Note that this is redundant - we can recover it by applying history
  *                 to the empty list, but stored here for efficiency.
  * @param history  A list of all operations that have been applied, in application order
  *                 Note that we must always have all operations, starting from revision
  *                 0 and using consecutive revision indices, so only operations are stored,
  *                 and each has a revision index equal to its index in the history.
  *                 TODO we can actually store a partial history if we reject operations
  *                 that were originally applied before the start of the partial history.
  */
case class ServerState[A](list: List[A], history: List[Operation[A]]) {

  //TODO look at adding logic here to allow for client to send ops at arbitrary point.
  //The simplest implementation is for a client always to send an operation against a known
  //revision from the server. This means it can send a new operation when it receives a new
  //state from the server (including a new revision of an OT list), but must then wait until
  //it receives another server state back to send another operation. This sets up a ping-pong
  //network flow. This has no particular disadvantages for the client in question, but means that
  //each other client only sees that client's OT updates at an interval determined by its latency.
  //This also complicates implementation of the client, since it must accumulate operations while
  //waiting to send them, and when it sends them it must transform them locally to come after the
  //server state it receives just before sending.
  //This seems to be needed because the client can't provide a revision against which the next operation should
  //be applied until it receives a new server state - we need the new operation to occur after
  //the previous one, so we can't use the old server state (without transforming at least - is there a way of doing this?).
  //However we could provide for the client to request that a new operation be applied after the previous operation sent by the
  //client. So we would provide say op1 to be applied against revision 42, and then op2 to be applied
  //after our previous operation, op2. When the server applies op1, it notes the revision that it was applied at,
  //say rev 44, and then when it receives the next op, op2, it applies it at rev 44, again noting rev 44 as
  //the point to apply the next operation from that client. This could be done by requiring a rev for the
  //first operation from a client, but then allowing this to be omitted for subsequent ones, with this
  //implying application just after the previous op.

  //To provide this, we will need some handling of additional data for OT transactions, this could be
  //done by allowing each transaction on an id to "store" and "retrieve" data when it is applied or
  //about to be applied, on the client and/or server side. This would make it general to similar transactions
  //rather than specific to current OT implementation.

  /**
    * Produce a ServerState that has been updated with an operation applied by a client on the list at specified
    * revision. Note that the client might have been out of date, in which case the operation must be transformed
    * to apply on the up to date list.
    * Also produces the transformed operation that was applied to the up to date list.
    * @param clientOpRev  The operation from the client, and the revision it produced on client when applied.
    * @return             A pair with new ServerState, and the transformed OpRev we applied
    */
  def updated(clientOpRev: OpRev[A]): (ServerState[A], OpRev[A]) = {
    val rev = clientOpRev.rev
    val clientOp = clientOpRev.op
    require(rev.i >= 0, "Revision index must be >= 0")
    // Each operation in history operates on the document revision matching its index
    // in history, and produces that document revision + 1. Hence `<=`
    require(rev.i <= history.size, s"Revision index ($rev) must be <= most recent revision (${history.size})")

    // The client op is at given rev, so operates on a document with this many
    // ops from history applied already. We drop these from history, leaving
    // only ops that the server applied AFTER this document state.
    val postOps = history.drop(rev.i)

    // We want to know what op will change the current list to reach the same
    // result that would be achieved by taking the client revision of the list,
    // then applying clientOp, then all of postOps in order
    // (transformed to apply after clientOp).
    //
    // The following diagram confusingly represents this. l is the initial list,
    // at the revision on which client op was performed. c is the client op.
    // pi is the ith postOp (i.e. server operation AFTER the client revision).
    // n is the final result of all the operations, the new list for the new
    // server state. Note that `after` is just a convenience method for
    // Operation.transform.
    //
    // Each position left to right represents a new state of the list. Moving
    // up represents applying the client op, or an operation transformed to
    // do the same thing after some other ops. Moving down represents applying
    // an op based on a server (post) op.
    //
    //    *
    //  /c \p0.after(c)
    // l    \p1.after(p1.after(c))
    //  \p0  \p2.after(p2.after(p1.after(c))
    //   \p1  n
    //    \p2/c.after(p0).after(p1).after(p2)
    //      *
    //
    // The top branch represents applying c, then applying p0 transformed to be
    // applied after c, then p1 transformed to be applied after THAT transformed
    // operation based on p0, etc. until we have applied all post ops. This is
    // what the client would get by applying its operation first, then the
    // server ops transformed appropriately to account for c.
    //
    // The branch we are more interested in is the bottom branch, where we work out
    // what operation needs to be applied after p0, p1 and p2, to get the same
    // end result n - this is c.after(p0).after(p1).after(p2). To see how we reach
    // this, consider step by step:
    //
    // After just p0 has been applied, this would just be c.after(p0):
    //
    //    *
    //  /c \p0.after(c)
    // l    l0
    //  \p0/c.after(p0)
    //    *
    //
    // This gets us to l0, we have moved one step closer to n.
    //
    // For the next step we need another diamond, but this time l is replaced by
    // l0, c is replaced by c.after(p0), and p0 is replaced by p1. This yields
    // c.after(p0).after(p1) in the lower right transformation. We can continue
    // until we reach n, with c.after(p0).after(p1).after(p2) as stated.
    //
    val postClientOp = postOps.foldLeft(clientOp){case (op, postOp) => op.after(postOp)}

    // New state and the new op that produced it
    (
      // Apply the op to our list, and add it to our history
      ServerState(postClientOp(list), history :+ postClientOp),

      // We have added postClientOp at the end of history with size n, so
      // it is the nth element (zero based)
      OpRev(postClientOp, Rev(history.size))

    )

  }
}

object ServerState {
  /**
    * Empty [[ServerState]] with empty list and history
    * @tparam A The type of list
    * @return   Empty ServerState
    */
  def empty[A]: ServerState[A] = ServerState(List.empty, List.empty)
}