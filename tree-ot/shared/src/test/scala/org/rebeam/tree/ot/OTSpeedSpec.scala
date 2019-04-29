package org.rebeam.tree.ot

import org.rebeam.tree.ot.OTGen._
import org.scalacheck.Prop._
import org.scalatest._
import org.scalatest.prop.Checkers

class OTSpeedSpec extends WordSpec with Matchers with Checkers {

  "Operation" should {
    "always transform pair (a, b) to (ap, bp) such that bp(a(i)) == ap(b(i)) for input i" in {
      try {
        check(
          forAll(genOperationPairAndInput[Int]) {
            p =>
              // Transform the pair
              val a = p.a
              val b = p.b
              val (ap, bp) = Operation.transform(a, b)
              val input = p.input

              bp(a(input)) == ap(b(input))

          }, MinSuccessful(20000)
        )
      } catch {
        case e: Throwable => e.printStackTrace()
      }
    }
  }
}
