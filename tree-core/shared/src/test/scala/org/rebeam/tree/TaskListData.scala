package org.rebeam.tree

import cats.Monad
import io.circe.generic.JsonCodec
import monocle.macros.Lenses
import org.rebeam.tree.codec.{Codec, IdCodec}
import org.rebeam.tree.codec.Codec._
import API._
import Edit._

object TaskListData {

  @JsonCodec
  @Lenses
  case class Task(name: String, done: Boolean)

  @JsonCodec
  @Lenses
  case class TaskList(id: Id[TaskList], name: String, tasks: List[Task])

  // Delta codecs

  implicit val taskDeltaCodec: Codec[Delta[Task]] = lens(Task.name, "name") or lens(Task.done, "done")

  // Can edit any list of Tasks using index (not the best approach - better to use a list of Refs,
  // then edit using Id, see RefTaskListDataSpec)
  implicit val tasksDeltaCodec: DeltaCodec[List[Task]] = listIndex[Task]

  implicit val taskListDeltaCodec: Codec[Delta[TaskList]] = lens(TaskList.name, "name") or lens(TaskList.tasks, "tasks")

  // Allows TaskLists to be put in STM
  implicit val taskListIdCodec: IdCodec[TaskList] = IdCodec[TaskList]("TaskList")

  val createTaskList: Edit[TaskList] = 
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

