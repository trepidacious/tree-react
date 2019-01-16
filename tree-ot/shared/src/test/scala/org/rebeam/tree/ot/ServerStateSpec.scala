package org.rebeam.tree.ot

import org.scalatest._
import org.scalatest.prop.Checkers

/**
  * Specification for [[ServerState]]
  */
class ServerStateSpec extends WordSpec with Matchers with Checkers {

  "ServerState" should {
    "not be identity with non-retain atoms" in {
      val s1 = ServerState.empty[Char]
      val op1 = Operation.fromAtoms(List(Atom.Insert("Hello World".toList)))
      val (s2, op1b) = s1.updated(OpRev(op1, 0))
      println(s"$s1 + $op1 => $s2, using $op1b")

      val op2 = Operation.fromAtoms(List(Atom.Insert("!".toList)))
      val (s3, op2b) = s2.updated(OpRev(op2, 0))
      println(s"$s2 + $op2 => $s3, using $op2b")

      println(s3.list.mkString)
    }

  }
}
