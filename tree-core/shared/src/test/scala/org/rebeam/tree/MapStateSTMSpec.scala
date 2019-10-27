package org.rebeam.tree

import cats.Monad
import cats.implicits._
import org.rebeam.tree.MapStateSTM._
import org.rebeam.tree.SpecUtils._
import org.rebeam.tree.TaskListData._
import org.rebeam.tree.codec.Codec.{DeltaCodec, otList}
import org.rebeam.tree.codec.IdCodec
import org.scalatest._
import org.scalatest.prop.Checkers
import org.rebeam.tree.codec.IdCodecs._
import org.rebeam.tree.ot.{OTList, OperationBuilder}

class MapStateSTMSpec extends WordSpec with Matchers with Checkers {

  def putTaskList[F[_]: Monad](implicit stm: STMOps[F]): F[TaskList] = {
    import stm._
    put[TaskList](
      TaskList(
        _,
        "Task List",
        List(
          Task("task 1", done = false),
          Task("task 2", done = true)
        )
      )
    )
  }

  def putInt[F[_]: Monad](implicit stm: STMOps[F]): F[Id[Int]] = {
    import stm._
    putWithId[Int](_ => 42).map(_._2)
  }

  val (exampleIntState, exampleIntId) = runS(putInt[MapState])

  def createExampleOTList[F[_]: Monad](implicit stm: STMOps[F]): F[OTList[Char]] = {
    import stm._
    createOTList[Char]("Hello".toList)
  }

  val (exampleOTListState, exampleOTList) = runS(createExampleOTList[MapState])

  lazy implicit val otListCharCodec: DeltaCodec[OTList[Char]] = otList[Char]
  lazy implicit val otListCharIdCodec: IdCodec[OTList[Char]] = IdCodec.otList[Char]

  def assertStable(s: StateData): Assertion = assert(!s.unstable)
  def assertUnstable(s: StateData): Assertion = assert(s.unstable)

  "MapStateSTM" should {
    "consider put stable" in {
      val (state, _) = runS(putTaskList[MapState])
      assertStable(state)
    }

    "consider get stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        get(exampleIntId),
        exampleIntState
      )
      assertStable(state)
    }

    "consider put then get stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- put[Int](_ => 43)
          _ <- get(exampleIntId)
        } yield (),
        exampleIntState
      )
      assertStable(state)
    }

    "consider get then put unstable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- get(exampleIntId)
          _ <- put[Int](_ => 43)
        } yield (),
        exampleIntState
      )
      assertUnstable(state)
    }

    "consider putFWithId stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(putFWithId[Int](_ => pure(42)))
      assertStable(state)
    }

    "consider putFWithId then get stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- putFWithId[Int](_ => pure(42))
          _ <- get(exampleIntId)
        } yield (),
        exampleIntState
      )
      assertStable(state)
    }

    "consider get then putFWithId unstable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- get(exampleIntId)
          _ <- putFWithId[Int](_ => pure(42))
        } yield (),
        exampleIntState
      )
      assertUnstable(state)
    }

    "consider modify stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- modify[Int](exampleIntId, _ + 1)
        } yield (),
        exampleIntState
      )
      assertStable(state)
    }

    "consider modifyF stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        modifyF[Int](exampleIntId, i => pure(i + 1)),
        exampleIntState
      )
      assertStable(state)
    }

    "consider modify then put unstable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- modify[Int](exampleIntId, _ + 1)
          _ <- put[Int](_ => 43)
        } yield (),
        exampleIntState
      )
      assertUnstable(state)
    }

    "consider modifyUnit then put stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- modifyUnit[Int](exampleIntId, _ + 1)
          _ <- put[Int](_ => 43)
        } yield (),
        exampleIntState
      )
      assertStable(state)
    }

    "consider modifyF then put unstable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- modifyF[Int](exampleIntId, i => pure(i + 1))
          _ <- put[Int](_ => 43)
        } yield (),
        exampleIntState
      )
      assertUnstable(state)
    }

    "consider modifyFUnit (with stable f) then put stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- modifyFUnit[Int](exampleIntId, i => pure(i + 1))
          _ <- put[Int](_ => 43)
        } yield (),
        exampleIntState
      )
      assertStable(state)
    }

    "consider modifyFUnit (with unstable f) unstable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        modifyFUnit[Int](
          exampleIntId,
          // This `f` is unstable in itself, so even calling it from a modifyFUnit won't
          // make that outer modifyFUnit stable
          _ => get[Int](exampleIntId) >> put[Int](_ => 43) >> pure(44)
        ),
        exampleIntState
      )
      assertUnstable(state)
    }

    "consider modifyFUnit (with unstable f) then put unstable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- modifyFUnit[Int](
            exampleIntId,
            // This `f` is unstable in itself, so even calling it from a modifyFUnit won't
            // make that outer modifyFUnit stable
            _ => get[Int](exampleIntId) >> put[Int](_ => 43) >> pure(44)
          )
          _ <- put[Int](_ => 43)
        } yield (),
        exampleIntState
      )
      assertUnstable(state)
    }

    "consider createGuid stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(createGuid)
      assertStable(state)
    }

    "consider createGuid then get stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- createGuid
          _ <- get(exampleIntId)
        } yield (),
        exampleIntState
      )
      assertStable(state)
    }

    "consider get then createGuid unstable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- get(exampleIntId)
          _ <- createGuid
        } yield (),
        exampleIntState
      )
      assertUnstable(state)
    }

    "consider put then put stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- put[Int](_ => 43)
          _ <- put[Int](_ => 43)
        } yield (),
        exampleIntState
      )
      assertStable(state)
    }

    "consider putF (with non-U f) then putF stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- putF[Int](_ => pure(43))
          _ <- put[Int](_ => 43)
        } yield (),
        exampleIntState
      )
      assertStable(state)
    }

    "consider putF (with U f, which reads state) stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        putF[Int](_ => get[Int](exampleIntId) >> pure(43)),
        exampleIntState
      )
      assertStable(state)
    }

    "consider putF (with U f, which reads state) then putF unstable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- putF[Int](_ => get[Int](exampleIntId) >> pure(43))
          _ <- put[Int](_ => 43)
        } yield (),
        exampleIntState
      )
      assertUnstable(state)
    }

    "consider putFJustId (with U f, which reads state) then putF stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- putFJustId[Int](_ => get[Int](exampleIntId) >> pure(43))
          _ <- put[Int](_ => 43)
        } yield (),
        exampleIntState
      )
      assertStable(state)
    }

    "consider createOTList stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- createOTList[Char]("Hello".toList)
        } yield (),
        exampleIntState
      )
      assertStable(state)
    }

    "consider createOTListF with non-U create stable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- createOTListF[Char](pure("Hello".toList))
        } yield (),
        exampleIntState
      )
      assertStable(state)
    }

    "consider createOTListF (with U create, which reads state) unstable" in {
      import MapStateSTM.stmInstance._
      val (state, _) = runS(
        for {
          _ <- createOTListF[Char](get[Int](exampleIntId).map(i => i.toString.toList))
          _ <- put[Int](_ => 43)
        } yield (),
        exampleIntState
      )
      assertUnstable(state)
    }

    "consider otListOperation stable" in {
      import MapStateSTM.stmInstance._
      val op = OperationBuilder.empty[Char].retain(5).insert(" World!".toList).build
      val (state, result) = runS(
        for {
          r <- otListOperation(exampleOTList, op)
        } yield r,
        exampleOTListState
      )
      assert(result.list == "Hello World!".toList)
      assertStable(state)
    }

    "consider otListOperation then another otListOperation unstable" in {
      import MapStateSTM.stmInstance._
      val op = OperationBuilder.empty[Char].retain(5).insert(" World!".toList).build
      val op2 = OperationBuilder.empty[Char].delete(6).retain(6).build

      val (state, result) = runS(
        for {
          _ <- otListOperation(exampleOTList, op)
          r <- otListOperation(exampleOTList, op2)
        } yield r,
        exampleOTListState
      )
      assert(result.list == "World!".toList)
      assertUnstable(state)
    }

    "consider otListOperationUnit then another otListOperation stable" in {
      import MapStateSTM.stmInstance._
      val op = OperationBuilder.empty[Char].retain(5).insert(" World!".toList).build
      val op2 = OperationBuilder.empty[Char].delete(6).retain(6).build

      val (state, result) = runS(
        for {
          _ <- otListOperationUnit(exampleOTList, op)
          r <- otListOperation(exampleOTList, op2)
        } yield r,
        exampleOTListState
      )
      assert(result.list == "World!".toList)
      assertStable(state)
    }

    "consider get then otListOperation unstable" in {
      import MapStateSTM.stmInstance._
      val op = OperationBuilder.empty[Char].retain(5).insert(" World!".toList).build
      val (state, (original, result)) = runS(
        for {
          o <- get[OTList[Char]](exampleOTList.id)
          r <- otListOperation(exampleOTList, op)
        } yield (o, r),
        exampleOTListState
      )
      assert(original.list == "Hello".toList)
      assert(result.list == "Hello World!".toList)
      assertUnstable(state)
    }

    "consider get then otListOperationUnit unstable" in {
      import MapStateSTM.stmInstance._
      val op = OperationBuilder.empty[Char].retain(5).insert(" World!".toList).build
      val (state, _) = runS(
        for {
          _ <- get[OTList[Char]](exampleOTList.id)
          _ <- otListOperationUnit(exampleOTList, op)
        } yield (),
        exampleOTListState
      )
      assertUnstable(state)
    }
  }

}
