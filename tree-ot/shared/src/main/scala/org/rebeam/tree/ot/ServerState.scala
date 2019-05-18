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
  *                 We also store the priority of each operation, for use when transforming
  *                 client operations against them.
  *                 We currently store all operations, starting from revision
  *                 0 and using consecutive revision indices, so only operations are stored,
  *                 and each has a revision index equal to its index in the history.
  *                 TODO we can actually store a partial history if we reject operations
  *                 that were originally applied before the start of the partial history, and store
  *                 the revision index of the data on which the first stored operation was applied.
  */
case class ServerState[A](list: List[A], history: List[PriorityOperation[A]]) {

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
    val clientPriority = clientOpRev.priority
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
    // l    \p1.after(c.after(p0))
    //  \p0  \p2.after(c.after(p0).after(p1))
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
    //    x
    //  /c \p0.after(c)
    // l    l0
    //  \p0/c.after(p0)
    //    y
    //
    // This is just the basic definition of "after", actually we are using both
    // outputs of Operation.transform here, and the relationship that if we have
    // (ap, bp) = transform(a, b) then bp(a(s)) = ap(b(s)) for any state s.
    //
    // This first step gets us to l0, i.e. the solution if we have only a single
    // operation p0 on the server that we need to move the client op "past", and
    // we have moved one step closer to n.
    //
    // For the next step we need another diamond, but using the bottom right
    // "side" of the first diamond as the top left side of our new diamond.
    // This means that:
    // Where we had l, we will instead have y (the bottom of the first diamond).
    // Where we had c, we will have c.after(p0).
    // Where we had p0, we will have p1.
    //
    //    l0
    //  /cap0 \p1.after(c.after(p0))
    // y       l1
    //  \p1   /(c.after(p0)).after(p1)
    //    y
    //
    // Note we have stretched out the diagram a little to fit the text, and shortened
    // c.after(p0) to "cap0" in the top left.
    // Following the transformation rule, we can fill out the top right, since we need
    // to transform p1 to be after cap0. We can fill out the bottom right since we need
    // cap0 to be after p1 (we've added unnecessary brackets to make this more obvious -
    // this is equivalent to just c.after(p0).after(p1).
    //
    // We can clearly continue this to ln, and the pattern is that the bottom right side,
    // i.e. the operation needed to apply the client operation c after the sequence of
    // server operations p0, p1 ... pn, is c.after(p0).after(p1)...after(pn), and the
    // top right operation is a little more confusing - it is:
    // pn.after(c.after(p0).after(p1)...after(pn-1))
    // So it's the last server operation, after the result of transforming the client operation
    // to be after all the other server operations except the last (i.e. p0 to pn-1).
    //
    // Note that this both tells us how to transform a client operation to be after multiple
    // other operations (on the bottom leg, as used on the server) and also tells us how
    // to transform a sequence of operations to be after a single operation - essentially
    // inserting an operation into a previously known sequence of operations. This is what
    // is required on the client side, to adapt buffered operations to a newly inserted server
    // operation (from a different client).
    // In general this allows us to make arbitrary insertions/appends to an existing sequence of \
    // operations.
    val postClientOp = postOps.foldLeft(clientOp){
      case (op, postOp) => {
        // Note we are transforming the client operation using after, so we compare client
        // priority to the postOp priority
        val clientIsHigherPriority = clientPriority > postOp.priority
        op.after(clientIsHigherPriority, postOp.op)
      }
    }

    // New state and the new op that produced it
    (
      // Apply the op to our list data, and add it to our history
      ServerState(postClientOp(list), history :+ PriorityOperation(postClientOp, clientPriority)),

      // We have added postClientOp at the end of history with size n, so
      // it is the nth element (zero based)
      OpRev(postClientOp, clientPriority, Rev(history.size))
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