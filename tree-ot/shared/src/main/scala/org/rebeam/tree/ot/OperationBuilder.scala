package org.rebeam.tree.ot

import org.rebeam.tree.ot.Atom._

/**
  * OperationBuilder provides a much more efficient way of building Operations using a series
  * of retain, insert and delete calls. This builds the list of atoms in reverse order
  * and then reverses the whole list when build is called.
 *
  * @param reverseAtoms The atoms of the final operation, in reverse order for efficiency
  * @tparam A           The type of element in the list edited by the operation
  */
case class OperationBuilder[A](reverseAtoms: List[Atom[A]]) extends AnyVal {

  /**
    * Retain n elements
    * @param n  The number of elements to retain
    * @return   A new Operation with additional elements retained
    */
  def retain(n: Int): OperationBuilder[A] = {
    require(n > 0, "must retain > 0 elements")
    reverseAtoms match {
      // If we have a Retain as last operation already, just merge that Retain with the new one,
      // otherwise append a new Retain.
      // We can't merge or swap with either insert or delete.
      case Retain(m) :: tail  =>  OperationBuilder[A](Retain[A](m + n) :: tail)
      case _                =>  OperationBuilder[A](Retain[A](n) :: reverseAtoms)
    }
  }

  /**
    * Retain n elements if n is positive, return same operation if n is zero.
    * @param n The number of elements to retain, or 0 to do nothing
    * @return  Operation with retain
    */
  def retainIfPositive(n: Int): OperationBuilder[A] = {
    require(n >= 0, "must retainIfPositive >= 0 elements")

    if (n > 0) {
      retain(n)
    } else {
      this
    }
  }

  def insert(l: List[A]): OperationBuilder[A] = {
    require(l.nonEmpty, "cannot insert empty list")
    // First, note that all inserts leave base length unaltered, and add the length of the
    // insert to target length.
    // Look at the last two atoms, if there are any.

    reverseAtoms match {
      // Last atom is Insert. We know we can't have last two elements as Delete, Insert since
      // we will never build this sequence, so just merge the Insert to make a new valid sequence
      case Insert(m) :: tail => OperationBuilder[A](Insert[A](m ++ l) :: tail)

      // We have an Insert, Delete pair, we can merge with the insert
      case Delete(d) :: Insert(m) :: tail => OperationBuilder[A](Delete[A](d) :: Insert[A](m ++ l) :: tail)

      // We have last element delete, and we have already excluded case where we have Insert, Delete, so
      // we need to replace the Delete with our new insert, then append the delete to the end to
      // form a valid Insert, Delete pair
      case Delete(d) :: tail => OperationBuilder[A](Delete[A](d) :: Insert[A](l) :: tail)

      // We have now excluded all sequences ending with an Insert or Delete, so there is nothing we can swap
      // or merge with - just append a new Insert
      case _ => OperationBuilder[A](Insert[A](l) :: reverseAtoms)
    }
  }

  def delete(n: Int): OperationBuilder[A] = {
    require(n > 0, "must delete > 0 elements")

    reverseAtoms match {
      // If we have a Delete as last operation already, merge with it.
      // We require an additional n characters in input string to do this,
      // target length is not affected
      case Delete(m) :: tail => OperationBuilder[A](Delete[A](m + n) :: tail)

      // Otherwise add new delete - we can't merge with a Delete, and if we have an Insert then we know
      // it is not preceded by a Delete, so we add the Delete to make an Insert, Delete pair.
      case _ => OperationBuilder[A](Delete[A](n) :: reverseAtoms)
    }

  }

  /**
    * Produce a new operation with this operation's effects, then another atom, which may
    * be merged/swapped with existing atoms in this operation.
    * @param atom The atom to run after this operation
    * @return     A new operation with the additional atom
    */
  def andThen(atom: Atom[A]): OperationBuilder[A] = atom match {
    case Insert(l) => insert(l)
    case Retain(n) => retain(n)
    case Delete(n) => delete(n)
  }

  /**
    * Build an operation from current state
    * @param priority The operation priority
    * @return A new Operation containing the atoms from this builder
    */
  def build(priority: Long): Operation[A] = Operation(reverseAtoms.reverse, priority)

}
object OperationBuilder {
  def apply[A]: OperationBuilder[A] = OperationBuilder(Nil)
  def empty[A]: OperationBuilder[A] = OperationBuilder(Nil)
  def fromOp[A](op: Operation[A]): OperationBuilder[A] = OperationBuilder(op.atoms.reverse)
}