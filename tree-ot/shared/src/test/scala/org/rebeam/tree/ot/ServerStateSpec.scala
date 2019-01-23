package org.rebeam.tree.ot

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
      val op0 = Operation.fromAtoms(List(Atom.Insert("Hello World".toList)))
      val (s1, op0b) = s0.updated(OpRev(op0, 0))
      assert(s1.list == "Hello World".toList)
      assert(op0b == OpRev(op0, 0))

      // Operation 1, will be applied on revision 1, producing revision 2
      val op1 = Operation.fromAtoms(List(Atom.Insert("!".toList)))
      // Note we apply this at revions 0 - it will be transformed to match
      // revision 1 (the current revision), and applied to revision 1
      val (s2, op1b) = s1.updated(OpRev(op1, 0))
      assert(s2.list == "!Hello World".toList)
      // Operation is updated to retain the new "Hello World" contents that
      // were added by operation 0
      assert(
        op1b == OpRev(
          Operation.fromAtoms[Char](
            List(
              Atom.Insert("!".toList),
              Atom.Retain(11)
            )
          ),
          1
        )
      )
    }

    "track edited position" in {
      val s0 = ServerState.empty[Char]
      val op0 = Operation.fromAtoms(List(Atom.Insert("1234".toList)))
      val (s1, op0b) = s0.updated(OpRev(op0, 0))
      println(s"$s0 + $op0 => $s1, using $op0b")

      // Client 1 wants to insert "x" between 2 and 3
      val opA1 = Operation.fromAtoms[Char](List(Atom.Retain(2), Atom.Insert("x".toList), Atom.Retain(2)))

      // Before it can, Client 2 inserts y at start of list
      val opB1 = Operation.fromAtoms[Char](List(Atom.Insert("y".toList), Atom.Retain(4)))
      val(s2, opB1s) = s1.updated(OpRev(opB1, 1))

      assert(s2.list == "y1234".toList)

      // Now Client 1's insertion is applied, the ServerState will transform it to
      // preserve intent of insertion (between 2 and 3)
      val(s3, opA1s) = s2.updated(OpRev(opA1, 1)) // Note this is still at Rev 1, even though server is at rev 2

      assert(s3.list == "y12x34".toList)
    }

  }
}
