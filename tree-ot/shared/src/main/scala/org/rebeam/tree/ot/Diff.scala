package org.rebeam.tree.ot


object Diff {
  /**
    * Generate a diff between two lists, as an Operation
    * @param o    The old list
    * @param n    The new list
    * @tparam A   The type of element
    * @return     An operation producing the change
    */
  def apply[A](o: List[A], n: List[A], priority: Int = 0): Operation[A] = {
    if (o eq n) {
      OperationBuilder[A].retain(o.size).build(priority)
    } else {

      //TODO implement

      Operation.empty()
    }
  }
}
