package org.rebeam.tree.ot

import org.rebeam.tree.ot.Atom._
import org.scalatest._
import org.scalatest.prop.Checkers

/**
  * Specification for [[ServerState]]
  */
class ServerStateSpec extends WordSpec with Matchers with Checkers {

  "ServerState" should {
    "handle simple case" in {
      val s0 = ServerState.empty[Char]

      // Operation 0, on revision 0, producing revision 1
      val op0 = Operation.fromAtoms(List(Insert("Hello World".toList)))
      val (s1, op0b) = s0.updated(OpRev(op0, Rev(0)))

      //Operation has been applied to list, on revision 0, with no
      //transformation required to operation
      assert(s1.list == "Hello World".toList)
      assert(op0b == OpRev(op0, Rev(0)))

      // Operation 1, will be applied on revision 1, producing revision 2
      val op1 = Operation.fromAtoms(List(Atom.Insert("!".toList)))
      // Note we apply this at revision 0 - it will be transformed to match
      // revision 1 (the current revision), and applied to revision 1
      val (s2, op1b) = s1.updated(OpRev(op1, Rev(0)))

      //Note that both operation 0 and operation 1 attempt to insert at the
      //start of the list, at revision 0. However operation 0 gets there first,
      //and so has higher priority - the inserted contents come first in the
      //resulting list. This puts the '!' on the end of the result.
      assert(s2.list == "Hello World!".toList)

      // Operation is updated to retain the new "Hello World" contents that
      // were added by operation 0
      assert(
        op1b == OpRev(
          Operation.fromAtoms[Char](
            List(
              Atom.Retain(11),
              Atom.Insert("!".toList)
            )
          ),
          Rev(1)
        )
      )
    }

    "track edited position" in {
      // Begin with a state where we have inserted "1234" into initial empty state
      val s0 = ServerState.empty[Char]
      val op0 = Operation.fromAtoms(List(Atom.Insert("1234".toList)))
      val (s1, op0s) = s0.updated(OpRev(op0, Rev(0)))

      // Check the server result is as expected, to rev 0
      assert(s1.list == "1234".toList)
      assert(op0s === OpRev(op0, Rev(0)))

      // Client 1 wants to insert "x" between 2 and 3
      val opA1 = Operation.fromAtoms[Char](List(Atom.Retain(2), Atom.Insert("x".toList), Atom.Retain(2)))

      // Before it can, Client 2 inserts y at start of list
      val opB1 = Operation.fromAtoms[Char](List(Atom.Insert("y".toList), Atom.Retain(4)))
      val(s2, opB1s) = s1.updated(OpRev(opB1, Rev(1)))

      // Check client 2 operation was performed as expected - operation should not need modification, and
      // is applied to rev 1
      assert(opB1s === OpRev(opB1, Rev(1)))
      assert(s2.list == "y1234".toList)

      // Now Client 1's insertion is applied, the ServerState will transform it to
      // preserve intent of insertion (between 2 and 3)
      val(s3, opA1s) = s2.updated(OpRev(opA1, Rev(1))) // Note this is still at Rev 1, even though server is at rev 2 - this
                                                  // is why we need to transform the operation.

      // Check we inserted the x between 2 and 3
      assert(s3.list == "y12x34".toList)

      //Check the operation was transformed correctly and was applied to rev 2
      assert(
        opA1s === OpRev(
          Operation.fromAtoms[Char](List(Atom.Retain(3), Atom.Insert("x".toList), Atom.Retain(2))),
          Rev(2)
        )
      )
    }

  }
}
