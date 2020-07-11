package org.rebeam.tree

import cats.Monad
import cats.implicits._
import io.circe.generic.JsonCodec
import monocle.macros.Lenses
import org.rebeam.tree.codec._
import org.rebeam.tree.codec.Codec._
import API._
import Edit._
import org.rebeam.tree.Implicits._

/**
  * Data example using a TaskList containing [[Ref]]s to Tasks with their
  * own [[Id]]s.
  */
object RefTaskListData {

  @JsonCodec
  @Lenses
  case class Task(id: Id[Task], name: String, done: Boolean) {
    def prettyPrint: String = s"[${if (done) "X" else " "}] $name"
  }

  @JsonCodec
  @Lenses
  case class TaskList(id: Id[TaskList], name: String, tasks: List[Ref[Task]])

  implicit val taskDeltaCodec: DeltaCodec[Task] = lens(Task.name, "name") or lens(Task.done, "done")

  // Can edit any list of Ref[Task] using a new value - note we would be editing the list contents, not the
  // individual Tasks, which are edited via their id in the STM
  // Note: A better approach would be to provide individual editing operations on the list, e.g. add, remove etc.,
  // or to provide these via actions on the TaskList
  implicit val tasksDeltaCodec: DeltaCodec[List[Ref[Task]]] = value[List[Ref[Task]]]

  implicit val taskListDeltaCodec: DeltaCodec[TaskList] = lens(TaskList.name, "name") or lens(TaskList.tasks, "tasks")

  // Allows Tasks and TaskLists to be put in STM
  implicit val taskIdCodec: IdCodec[Task] = IdCodec[Task]("Task")

  implicit val taskListIdCodec: IdCodec[TaskList] = IdCodec[TaskList]("TaskList")

  def createTask(i: Int): Edit[Ref[Task]] = 
    put(Task(_, s"Task $i", done = i % 2 == 0)).map(task => Ref(task.id))

  val createTaskList: Edit[TaskList] = for {
      tasks <- 1.to(10).toList.traverse(createTask)
      taskList <- put[TaskList](TaskList(_, "Task List", tasks))
    } yield taskList

  def printTaskList(l: TaskList): Read[String] = for {
      tasks <- l.tasks.deref
    } yield s"${l.name}: ${tasks.map(_.prettyPrint).mkString(", ")}"

}
