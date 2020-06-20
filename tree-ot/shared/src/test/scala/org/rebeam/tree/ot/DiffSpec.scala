package org.rebeam.tree.ot

import org.rebeam.tree.ot.OTGen._
import org.scalacheck.Prop._
import org.scalacheck.Prop.forAll
import org.scalatest.matchers.should.Matchers
import org.scalatest._
import org.scalatestplus.scalacheck.Checkers


class DiffSpec extends wordspec.AnyWordSpec with Matchers with Checkers {

  def assertDiff(o: String, n: String, eOp: Operation[Char]): Unit = {
    val op = Diff(o.toList, n.toList)
    assert(op === eOp)
    val n2 = op.apply(o.toList).mkString
    assert(n === n2)
    ()
  }

  "Diff" should {
    "find a simple insert" in {
      val o = "Hello World"
      val n = "Hello! World"
      assertDiff(o, n, OperationBuilder[Char].retain(5).insert("!".toList).retain(6).build)
    }

    "replicate arbitrary operations" in {
      check (
        forAll(genAtomListAndInput[Int]) {
          ai =>
            val op = Operation.fromAtoms(ai.atoms)
            val o = ai.input
            val n = op(o)
            val d = Diff(o, n)
            d(o) == n
        }, MinSuccessful(10000)
      )
    }
  }

}
