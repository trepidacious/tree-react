package org.rebeam.tree

import cats.Monad
import cats.implicits._
import org.rebeam.tree.MapStateSTM._
import org.rebeam.tree.SpecUtils._
import org.rebeam.tree.TaskListData._
import org.scalatest._
import org.scalatest.prop.Checkers

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

  "MapStateSTM" should {
    "consider put stable" in {
      val (state, _) = runS(putTaskList[MapState])
      assert(!state.unstable)
    }
  }

}
