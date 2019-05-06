package org.rebeam.tree.ot

/**
  * The state of a cursor into a list, synchronised to a ClientState
  * @param cursorIndex    The position of the cursor
  * @param lastClientRev  The last client revision we updated against
  * @tparam A             The type of list element
  */
case class CursorState[A](cursorIndex: Int, lastClientRev: Int) {
  def update(c: ClientState[A]): CursorState[A] = {
    if (c.clientRev == lastClientRev + 1) {
      c.previousLocalUpdate.fold[CursorState[A]](
        copy(lastClientRev = c.clientRev)
      )(
        u => {
          val newCursorIndex = u.op.transformCursor(cursorIndex, u.ownOperation)
          copy(newCursorIndex, c.clientRev)
        }
      )
    } else {
      copy(0, c.clientRev)
    }
  }
}

object CursorState {

  /**
    * Create a CursorState
    * @param c            The ClientState
    * @param cursorIndex  The initial cursor index
    * @tparam A           The type of list element
    * @return             A new CursorState
    */
  def apply[A](c: ClientState[A], cursorIndex: Int = 0): CursorState[A] = CursorState(cursorIndex, c.clientRev)
}
