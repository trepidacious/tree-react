package org.rebeam.demo

import cats.Monad
import cats.implicits._
import org.rebeam.tree.MapStateSTM.StateDelta
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Component
import japgolly.scalajs.react.vdom.html_<^._
import org.rebeam.tree._
import org.rebeam.tree.react._
import TodoData._
import org.log4s.getLogger
import org.rebeam._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal
class InputEvent extends js.Object {
  def dataTransfer: js.Any = js.native
  def getTargetRanges(): js.Any = js.native
}

object LocalDataRootDemo {

  // Our index is simple - just store the most recently added list.
  // The index lets us access this list by retrieving its Id from the TodoList in the index.
  // Otherwise we wouldn't know the Id, since we don't get any return value from the exampleData Transaction.
  case class TodoIndex(todoList: Option[TodoList])

  // This indexer will just keep the last put or modified TodoList
  val todoIndexer: LocalDataRoot.Indexer[TodoIndex] = new LocalDataRoot.Indexer[TodoIndex] {
    def initial: TodoIndex = TodoIndex(None)
    def updated(index: TodoIndex, deltas: Seq[StateDelta[_]]): TodoIndex = {
      deltas.foldRight(index){
        case (delta, i) => delta.a match {
          case tl: TodoList => TodoIndex(Some(tl))
          case _ => i
        }
      }
    }
  }


  val stringView: Component[Cursor[String], Unit, Unit, CtorType.Props] = new ViewPC[String] {
    private val logger = getLogger

    override def apply(a: Cursor[String])(implicit tx: ReactTransactor): VdomNode = {

      logger.debug(s"stringView applying from $a, transactor $tx")

      // Editing the value is straightforward - just call set on the cursor. The cursor
      // creates a ValueDelta that will set the String directly to a new value, makes
      // a Transaction from the delta using the context provided by the cursor, and
      // then uses the implicit ReactTransactor to convert the Transactor to a Callback
      // we can give to React.
      
      // Note we can use e.target.value directly - set accepts a plain value, not a function,
      // so we don't have to worry about the event being reused. Of course the Callback produced
      // will not be used until later.
      def onChange(e: ReactEventFromInput): Callback = a.set(e.target.value)

      sui.Input(
        value = a.a,
        onChange = onChange(_)
      )()
    }

  }.build("stringView")

  // A View accepting the Id of a TodoItem.
  // This is a View so that it can use ReactViewOps to create a cursor at the id to view/edit the TodoItem.
  // The view will be re-rendered whenever the data at the Id changes.
  val todoItemView: Component[Id[TodoItem], Unit, Unit, CtorType.Props] = new View[Id[TodoItem]] {
    private val logger = getLogger

    def apply[F[_]: Monad](id: Id[TodoItem])(implicit v: ReactViewOps[F], tx: ReactTransactor): F[VdomElement] = {
      logger.debug(s"View applying from $id")

      // By creating a cursor at the Id, we can enable navigation through the TodoItem
      v.cursorAt[TodoItem](id).map(
        cursor => {

          // We want to use a sui.Input directly below so we can pass in the checkbox as a label,
          // so we need to handle changes here
          val textCursor = cursor.zoom(TodoItem.text)
          def onChange(e: ReactEventFromInput): Callback = textCursor.set(e.target.value)

          // Checkbox to use to complete/un-complete todo item
          val checkbox = sui.Checkbox(
            className = SUIStyles.checkboxLabelFitted.htmlClass,  // Use scalacss style to fix styling
            checked = cursor.a.completed.isDefined,
            onChange = (_: ReactEvent, p: sui.Checkbox.Props) =>
              cursor.delta(TodoItemCompletion(p.checked.getOrElse(false)))
          )

          // Actual display is a list item containing an input, with the checkbox as the input's label
          sui.ListItem()(
            sui.Input(
              fluid = true,
              label = checkbox.raw, // Note we need to pass raw component, since we are going straight to JS property
              value = textCursor.a,
              onChange = onChange(_)
            )()
          )
        }
      )
    }
  }.build("todoItemView")

  // This component uses a child view for each item in the list, each of these will update only when the TodoItem
  // referenced by that Id changes.
  // Note that this does not need to be a View itself since it doesn't actually get the data by id - the child views
  // can still get data from the Context provided by dataProvider, so this can be a ViewP
  val todoListView: Component[TodoList, Unit, Unit, CtorType.Props] = new ViewP[TodoList] {
    override def apply(a: TodoList): VdomNode = {
      sui.List(
        verticalAlign = sui.List.VerticalAlign.Middle,
        relaxed = true: js.Any
      )(
        a.items.toVdomArray(id => todoItemView.withKey(id.toString)(id))
      )
    }
  }.build("todoListView")

  // This component will manage and render an STM, initialised to the example data
  // We only use the index for data, so the model is Unit
  val dataProvider = LocalDataRoot.component[Unit, TodoIndex](
    (_, index) =>
      <.div(
        // When we have an indexed TodoList, display it
        index.todoList.whenDefined(todoListView(_))
      )
  )(
    todoIndexer,  //This indexer will provide the most recently added list
    example       //This example Transaction populates the STM to display
  )

}
