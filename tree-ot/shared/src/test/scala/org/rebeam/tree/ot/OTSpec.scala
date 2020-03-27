package org.rebeam.tree.ot

import org.scalatest.matchers.should.Matchers
import org.scalatest._
import org.scalatestplus.scalacheck.Checkers

import Atom._
import org.scalacheck.Prop._
import org.rebeam.tree.ot.OTGen._

import scala.annotation.tailrec

class OTSpec extends wordspec.AnyWordSpec with Matchers with Checkers {

  // Initial text
  val input1 = "Hello World!"

  // Operation for "client a" - insert "big wide" and delete the "!"
  val op1a: Operation[Char] = OperationBuilder[Char].retain(6).insert("big wide ".toList).retain(5).delete(1).build
  val output1a = "Hello big wide World"

  // Operation for "client b" - add smiley
  val op1b: Operation[Char] = OperationBuilder[Char].retain(12).insert(" :)".toList).build
  val output1b = "Hello World! :)"

  // Expected result of combining op1a then op1b, or op1b then op1a
  val output1ab = "Hello big wide World :)"

  @tailrec
  private final def isRORORec[A](atoms: List[Atom[A]]): Boolean = {
    atoms match {

      //Each case for "RO" section
      case Retain(_) :: Insert(_) :: Delete(_) :: as => isRORORec(as)
      case Retain(_) :: Insert(_) :: as => isRORORec(as)
      case Retain(_) :: Delete(_) :: as => isRORORec(as)

      //Final single retain is fine
      case Retain(_) :: Nil => true

      //Nothing left, so all sections must have been fine
      case Nil => true

      //We have a non-permitted sequence
      case _ => false
    }
  }

  private final def isRORO[A](op: Operation[A]): Boolean = {
    op.atoms match {

      // Start is special case - we can have an "O" section
      // at the start without an initial R, then we hand over
      // to normal rules for the rest of the atoms
      case Insert(_) :: Delete(_) :: as => isRORORec(as)
      case Insert(_) :: as => isRORORec(as)
      case Delete(_) :: as => isRORORec(as)

      // Must have an initial R or be Nil, so we can let
      // recursive method at it
      case as => isRORORec(as)
    }
  }

  private final def assertCursorTransform[A](op: Operation[A], isEditor: Option[Boolean] = None)(results: (Int, Int)*): Unit = {
    val isEditorCases: List[Boolean] = isEditor.map(List(_)).getOrElse(List(true, false))
    for {
      e <- isEditorCases
      (from, to) <- results
    } {
      assert(op.transformCursor(from, isEditor = e) === to, s"$op should move cursor from $from to $to when it ${if(e) "is" else "is not"} the editor")
    }
  }

  "Atoms" should {
    "give correct insertion deltas" in {
      val i = Insert(List(1,2,3))
      assert(i.inputLengthDelta == 0)
      assert(i.outputLengthDelta == 3)
    }
    "give correct retain deltas" in {
      val i = Retain(4)
      assert(i.inputLengthDelta == 4)
      assert(i.outputLengthDelta == 4)
    }
    "give correct delete deltas" in {
      val i = Delete(5)
      assert(i.inputLengthDelta == 5)
      assert(i.outputLengthDelta == 0)
    }
    "require positive retain count" in {
      assertThrows[IllegalArgumentException](Retain(-1))
      assertThrows[IllegalArgumentException](Retain(0))
      Retain(1)
    }
    "require non empty insert size" in {
      assertThrows[IllegalArgumentException](Insert(List.empty[Int]))
      Insert(List(1))
    }
    "require positive delete count" in {
      assertThrows[IllegalArgumentException](Delete(-1))
      assertThrows[IllegalArgumentException](Delete(0))
      Delete(1)
    }
  }

  "Operations " should {
    "apply simple case 1a" in {
      assert(
        op1a(input1.toList).mkString == output1a
      )
    }

    "invert simple case 1a" in {
      assert(
        op1a.inverse(input1.toList).apply(output1a.toList).mkString == input1
      )
    }

    "apply simple case 1b" in {
      assert(
        op1b(input1.toList).mkString == output1b
      )
    }

    "invert simple case 1b" in {
      assert(
        op1b.inverse(input1.toList).apply(output1b.toList).mkString == input1
      )
    }

    "transform and apply simple case 1 concurrent ops a and b" in {
      val (ap, bp) = Operation.transform(op1a, op1b)
      assert(ap(output1b.toList) == output1ab.toList)
      assert(bp(output1a.toList) == output1ab.toList)
    }

    "transform and apply insertion at the same point to give same results, with left operation given priority" in {
      val a = OperationBuilder[Char].retain(3).insert(List('a')).retain(3).build
      val b = OperationBuilder[Char].retain(3).insert(List('b')).retain(3).build

      val (ap, bp) = Operation.transform(a, b)

      val l = "123456".toList

      assert(ap(b(l)) == bp(a(l)))
      assert(ap(b(l)) == bp(a(l)))

      //Note that a gets priority over b, since it is on left of transform
      assert(ap(b(l)) == "123ab456".toList)

      //Note that b now gets priority over a, since it is on left of transform
      val (bp2, ap2) = Operation.transform(b, a)
      assert(ap2(b(l)) == bp2(a(l)))
      assert(ap2(b(l)) == bp2(a(l)))
      assert(ap2(b(l)) == "123ba456".toList)
    }

    "coalesce retains" in {
      assert(
        OperationBuilder[Int].retain(1).retain(100).build.atoms
          == OperationBuilder[Int].retain(101).build.atoms
      )
    }

    "coalesce deletes" in {
      assert(
        OperationBuilder[Int].delete(1).delete(100).build.atoms
          == OperationBuilder[Int].delete(101).build.atoms
      )
    }

    "coalesce inserts" in {
      assert(
        OperationBuilder[Int].insert(List(1)).insert(List(2,3,4)).build.atoms
          == OperationBuilder[Int].insert(List(1,2,3,4)).build.atoms
      )
    }

    "always have `RORO` invariant" in {
      check{
        forAll(genAtomListAndInput[Int]) {
          ai =>
            val op = Operation.fromAtoms(ai.atoms)
            isRORO(op)
        }
      }
    }

    "always give the same result of correct length when coalesced as when using all atoms" in {
      check{
        forAll(genAtomListAndInput[Int]) {
          ai =>
            val op = Operation.fromAtoms(ai.atoms)
            val opAtoms = Operation(ai.atoms)
            val output = op(ai.input)
            val outputAtoms = opAtoms(ai.input)

            (output == outputAtoms) &&
              (output.size == op.outputSize) &&
              (outputAtoms.size == opAtoms.outputSize)
        }
      }
    }

    "always have inverse such that a.inverse(a(i)) == i for input i" in {
      check{
        forAll(genAtomListAndInput[Int]) {
          ai =>
            val op = Operation.fromAtoms(ai.atoms)
            val inverse = op.inverse(ai.input)
            inverse(op(ai.input)) == ai.input
        }
      }
    }

    "always compose so that a.compose(b)(i) == b(a(i)) for input i" in {
      check(
        forAll(genOperationComposePairAndInput[Int]) {

          p => p.a.compose(p.b)(p.input) == p.b(p.a(p.input))

        }, MinSuccessful(10000)
      )
    }

    "always transform pair (a, b) to (ap, bp) such that bp(a(i)) == ap(b(i)) for input i" in {
      check(
        forAll(genOperationPairAndInput[Int]) {
          p =>
            // Transform the pair
            val a = p.a
            val b = p.b
            val (ap, bp) = Operation.transform(a, b)
            val input = p.input

            bp(a(input)) == ap(b(input))

        }, MinSuccessful(10000)
      )
    }

    "require positive retain count" in {
      assertThrows[IllegalArgumentException](OperationBuilder[Int].retain(-1))
      assertThrows[IllegalArgumentException](OperationBuilder[Int].retain(0))
      OperationBuilder[Int].retain(1)
    }

    "require non-negative retainIfPositive count" in {
      assertThrows[IllegalArgumentException](OperationBuilder[Int].retainIfPositive(-1))
      OperationBuilder[Int].retainIfPositive(0)
      OperationBuilder[Int].retainIfPositive(1)
    }

    "require non empty insert size" in {
      assertThrows[IllegalArgumentException](OperationBuilder[Int].insert(List.empty[Int]))
      OperationBuilder[Int].insert(List(1))
    }

    "require positive delete count" in {
      assertThrows[IllegalArgumentException](OperationBuilder[Int].delete(-1))
      assertThrows[IllegalArgumentException](OperationBuilder[Int].delete(0))
      OperationBuilder[Int].delete(1)
    }

    "be identity with no atoms" in {
      assert(Operation.empty[Int].isIdentity)
    }

    "be identity with only retains" in {
      assert(OperationBuilder[Int].retain(3).build.isIdentity)
      assert(OperationBuilder[Int].retain(100).retain(1000).build.isIdentity)
    }

    "not be identity with non-retain atoms" in {
      assert(!OperationBuilder[Int].insert(List(1)).build.isIdentity)
      assert(!OperationBuilder[Int].retain(100).insert(List(1, 2)).build.isIdentity)
      assert(!OperationBuilder[Int].delete(1).build.isIdentity)
      assert(!OperationBuilder[Int].retain(100).delete(100).build.isIdentity)
      assert(!OperationBuilder[Int].insert(List(1, 2)).delete(100).build.isIdentity)
    }

    "transform cursor for deletion" in {
      // Initial text
      val s = "abcde".toList

      // Operation to delete "d"
      val deleteD = OperationBuilder[Char].retain(3).delete(1).retain(1).build

      // Check operation is as expected
      assert(deleteD(s).mkString === "abce")

      // Check cursor transformations are as expected
      // Cursor positions before deletion - i.e. cursorIndex 0 is before first letter, a:
      // 0 a 1 b 2 c 3 d 4 e 5
      // After deleting "d" we should have:
      // 0 a 1 b 2 c 3,4 e 5
      // 0   1   2    3    4<- new cursor index
      // i.e. if the cursor was just before or after d, it is now before e
      assertCursorTransform(deleteD)(
        0 -> 0,
        1 -> 1,
        2 -> 2,
        3 -> 3,
        4 -> 3,
        5 -> 4
      )
    }

    "transform cursor for multiple deletion" in {
      // Initial text
      val s = "abcde".toList

      // Operation to delete "bcd"
      val deleteD = OperationBuilder[Char].retain(1).delete(3).retain(1).build

      // Check operation is as expected
      assert(deleteD(s).mkString === "ae")

      // Check cursor transformations are as expected
      // Cursor positions before deletion - i.e. cursorIndex 0 is before first letter, a:
      // 0 a 1 b 2 c 3 d 4 e 5
      // After deleting "bcd" we should have:
      // 0 a 1,2,3,4 e 5
      // 0      1      2  <- new cursor index
      // i.e. if the cursor was just before or after d, it is now before e
      assertCursorTransform(deleteD)(
        0 -> 0,
        1 -> 1,
        2 -> 1,
        3 -> 1,
        4 -> 1,
        5 -> 2
      )
    }

    "transform cursor for insertion" in {
      // Initial text
      val s = "abcde".toList

      // Operation to insert X after "c"
      val op = OperationBuilder[Char].retain(3).insert("X".toList).retain(2).build

      // Check operation is as expected
      assert(op(s).mkString === "abcXde")

      // Check cursor transformations are as expected
      // Cursor positions before deletion - i.e. cursorIndex 0 is before first letter, a:
      // 0 a 1 b 2 c 3 d 4 e 5
      // Cursor indices 0, 1, 2 are unaltered.
      // If we are the editor, cursor index 3 (just after c) and later will increase by 1
      // 0 a 1 b 2 c   X 3 d 4 e 5
      // 0   1   2   3   4   5   6  <- new cursor index
      assertCursorTransform(op, Some(true))(
        0 -> 0,
        1 -> 1,
        2 -> 2,
        3 -> 4,
        4 -> 5,
        5 -> 6
      )

      // If we are not the editor, cursor index 4 and later will increase by 1
      // 0 a 1 b 2 c 3 X   d 4 e 5
      // 0   1   2   3   4   5   6  <- new cursor index
      assertCursorTransform(op, Some(false))(
        0 -> 0,
        1 -> 1,
        2 -> 2,
        3 -> 3,
        4 -> 5,
        5 -> 6
      )
    }

    "transform cursor for multiple insertion" in {
      // Initial text
      val s = "abcde".toList

      // Operation to insert XYZ after "c"
      val op = OperationBuilder[Char].retain(3).insert("XYZ".toList).retain(2).build

      // Check operation is as expected
      assert(op(s).mkString === "abcXYZde")

      // Check cursor transformations are as expected
      // Cursor positions before deletion - i.e. cursorIndex 0 is before first letter, a:
      // 0 a 1 b 2 c 3 d 4 e 5
      // Cursor indices 0, 1, 2 are unaltered.
      // If we are the editor, cursor index 3 (just after c) and later will increase by 3
      // 0 a 1 b 2 c   X   Y   Z 3 d 4 e 5
      // 0   1   2   3   4   5   6   7   8 <- new cursor index
      assertCursorTransform(op, Some(true))(
        0 -> 0,
        1 -> 1,
        2 -> 2,
        3 -> 6,
        4 -> 7,
        5 -> 8
      )

      // If we are not the editor, cursor index 4 and later will increase by 3
      // 0 a 1 b 2 c 3 X   Y   Z   d 4 e 5
      // 0   1   2   3   4   5   6   7   8 <- new cursor index
      assertCursorTransform(op, Some(false))(
        0 -> 0,
        1 -> 1,
        2 -> 2,
        3 -> 3,
        4 -> 7,
        5 -> 8
      )
    }

    "transform cursor for insertion and deletion" in {
      // Initial text
      val s = "Hello World!".toList

      // Operation to insert XYZ after "c"
      val op = OperationBuilder[Char].retain(6).insert("big wide ".toList).retain(5).delete(1).build

      // Check operation is as expected
      assert(op(s).mkString === "Hello big wide World")

      // Check cursor transformations are as expected
      // Cursor positions before deletion - i.e. cursorIndex 0 is before first letter, a:
      // 0 H 1 e 2 l 3 l 4 o 5 _ 6 W 7 o 8 r 9 l 10 d 11 ! 12
      //
      // If we are not the editor:
      // Cursor indices 0 to 6 are unaltered.
      // 7 to 11 are shifted 9 to the right.
      // 12 shifts to same position as 11 (so ends up at 11 + 9 = 20)
      assertCursorTransform(op, Some(false))(
        0 -> 0,
        1 -> 1,
        2 -> 2,
        3 -> 3,
        4 -> 4,
        5 -> 5,
        6 -> 6,
        7 -> 16,
        8 -> 17,
        9 -> 18,
        10 -> 19,
        11 -> 20,
        12 -> 20
      )

      // If we are the editor:
      // Cursor indices 0 to 5 are unaltered.
      // 6 to 11 are shifted 9 to the right.
      // 12 shifts to same position as 11 (so ends up at 11 + 9 = 20)
      assertCursorTransform(op, Some(true))(
        0 -> 0,
        1 -> 1,
        2 -> 2,
        3 -> 3,
        4 -> 4,
        5 -> 5,
        6 -> 15,
        7 -> 16,
        8 -> 17,
        9 -> 18,
        10 -> 19,
        11 -> 20,
        12 -> 20
      )

    }

  }
}
