package org.rebeam.tree.slinkify

/**
  * Reusability for Views, where we know that only immutable data is used.
  * We provide two implicit implementations, one for AnyVal and one for AnyRef.
  * It is also possible to create a custom implementation, if we know that some part of a value is not used
  * by any View.
  *
  * This provides a fast way of detecting changes to data, where:
  *
  * 1. We can tolerate a low rate of "false-inequality" where we report a change when none has occurred, but
  * 2. We must have no "false-equality" where we report no change when one has happened
  *
  * For AnyVal this is easy - using == is both fast and perfectly accurate.
  *
  * For AnyRef, knowing that the data is immutable means that 2 can be satisfied by using eq - the contents
  * of an instance of the data never changed, so if eq returns true we are looking at the same instance, and
  * therefore the contents must be equal (for example by ==, but in general actually by any means at all,
  * assuming referential transparency).
  *
  * This just leaves requirement 1 - in a sensibly designed system we will not create additional equal instances
  * of a data item, so the rate of false-inequality will be low in general. In particular the comparison is used
  * between successive props of the same view, where there is even less chance of setting a new value as an exact
  * copy of the previous value.
  */
sealed trait Reusability[A] {
  def test(a1: A, a2: A): Boolean

  /**
    * Create a Reusability for Cursor[AA], for some subtype AA of A
    * This will compare the model value using reusability[AA], and the DeltaCursor
    * by equality (since DeltaCursors may be be recreated without changing contents,
    * during a render)
    *
    * @tparam AA  The subtype in the Cursor
    * @return     A Reusability for the Cursor
    */
  def cursorReusability[AA <: A]: Reusability[Cursor[AA]] = Reusability[Cursor[AA]](
    (dA1, dA2) => test(dA1.a, dA2.a) && (dA1.deltaCursor == dA2.deltaCursor)
  )
}

object Reusability {
  implicit def anyVal[A <: AnyVal]: Reusability[A] = new Reusability[A]{
    def test(a1: A, a2: A): Boolean = a1 == a2
  }
  implicit def anyRef[A <: AnyRef]: Reusability[A] = new Reusability[A]{
    def test(a1: A, a2: A): Boolean = a1 eq a2
  }
  def apply[A](f: (A, A) => Boolean): Reusability[A] = new Reusability[A] {
    override def test(a1: A, a2: A): Boolean = f(a1, a2)
  }
}