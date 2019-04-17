package org.rebeam.tree

import cats.implicits._
import io.circe._
import org.rebeam.tree.Delta._
import org.rebeam.tree.TaskListData._
import org.rebeam.tree.MapStateSTM._
import org.rebeam.tree.Transaction.DeltaAtId
import org.rebeam.tree.codec.Codec.DeltaCodec
import org.rebeam.tree.codec.TransactionCodec
import org.scalatest._
import org.scalatest.prop.Checkers

import SpecUtils._

class TaskListDataSpec extends WordSpec with Matchers with Checkers {

  private def taskListResult = runS(createTaskList[MapState])

  private val taskListGuid = guid(0, 0, 0)

  private val taskListId = Id[TaskList](taskListGuid)

  "TaskListData" should {

    "create expected data" in {
      val (s1, taskList) = taskListResult

      assert(taskList == TaskList(taskListId, "Task List", List(Task("task 1", done = false), Task("task 2", done = true))))
      assert(s1.getDataRevision(taskListId).contains(DataRevision(taskList, RevId(guid(0, 0, 1)), taskListIdCodec)))
      assert(s1.nextGuid ==guid(0, 0, 2))
    }

    "use cursor to task list name" in {

      val (s1, taskList) = taskListResult

      // Cursor at the name of task list
      val taskListName = DeltaCursor
        .AtId(taskList.id)
        .zoom(TaskList.name)

      val newName = "The list of tasks"

      val t1 = taskListName.set(newName)

      // We should have a transaction with expected delta at expected id
      assert (t1 == DeltaAtId(taskListId, LensDelta(TaskList.name, ValueDelta(newName))))

      val (s2, _) = runS(t1[MapState], s1)

      assert(s2.getData(taskListId).map(_.name).contains(newName))

    }

    "use cursor to first task's name" in {

      val (s1, taskList) = taskListResult

      // Cursor at the name of the first task
      val firstTaskName = DeltaCursor
        .AtId(taskList.id)
        .zoom(TaskList.tasks)
        .zoomIndex(0)
        .zoom(Task.name)

      val newName = "The First Task"

      val t1 = firstTaskName.set(newName)

      // We should have a transaction with expected delta at expected id
      assert (t1 ==
        DeltaAtId(
          taskListId,
          LensDelta(
            TaskList.tasks,
            TraversableIndexDelta[List, Task](
              0,
              LensDelta(
                Task.name,
                ValueDelta(newName)
              )
            )
          )
        )
      )

      val (s2, _) = runS(t1[MapState], s1)

      assert(s2.getData(taskListId).map(_.tasks.head.name).contains(newName))
    }
  }

  "encode and decode delta on first task's name" in {

    val newName = "The First Task"

    val delta: Delta[TaskList] = LensDelta(
      TaskList.tasks,
      TraversableIndexDelta[List, Task](
        0,
        LensDelta(
          Task.name,
          ValueDelta(newName)
        )
      )
    )

    import org.rebeam.tree.codec.syntax._

    val deltaJson = delta.asJsonOption

    assert(deltaJson.contains(
      Json.obj(
        "LensDelta" -> Json.obj(
          "tasks" -> Json.obj(
            "TraversableIndexDelta" -> Json.obj(
              "index" -> Json.fromInt(0),
              "delta" -> Json.obj(
                "LensDelta" -> Json.obj(
                  "name" -> Json.obj(
                    "ValueDelta" -> Json.fromString(newName)
                  )
                )
              )
            )
          )
        )
      )
    ))

    val deltaDecoded = deltaJson.flatMap(implicitly[DeltaCodec[TaskList]].decoder.decodeJson(_).toOption)

    assert(deltaDecoded.contains(delta))
  }

  "encode and decode transaction on first task's name" in {

    val (s1, taskList) = taskListResult

    // Cursor at the name of the first task
    val firstTaskName = DeltaCursor
      .AtId(taskList.id)
      .zoom(TaskList.tasks)
      .zoomIndex(0)
      .zoom(Task.name)

    val newName = "The First Task"

    val t1: Transaction = firstTaskName.set(newName)

    val t1e = TransactionCodec.deltaAtIdCodec.encoder(t1)(s1)

//    println(t1e)

    //TODO continue

  }


}
