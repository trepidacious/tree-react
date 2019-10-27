package org.rebeam.tree

import cats.Monad
import cats.implicits._
import org.rebeam.tree.MapStateSTM._
import org.rebeam.tree.SpecUtils._
import org.rebeam.tree.TaskListData._
import org.scalatest._
import org.scalatest.prop.Checkers
import org.rebeam.tree.codec.IdCodecs._

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

  "MapStateSTM" should {
    "consider put stable" in {
      val (state, _) = runS(putTaskList[MapState])
      assert(!state.unstable)
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
      assert(state.unstable)
    }
  }

}
