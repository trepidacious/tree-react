package org.rebeam

import cats.Monad
import cats.implicits._
import org.log4s.getLogger
import org.rebeam.TodoData._
import org.rebeam.tree.Delta.OTListDelta
import org.rebeam.tree.MapStateSTM.StateDelta
import org.rebeam.tree._
import org.rebeam.tree.ot.{Diff, OTList}
import org.rebeam.tree.slinkify._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import slinky.core.FunctionalComponent
import slinky.core.facade.ReactElement
import slinky.web.html._
import typings.antdLib.AntdFacade.{List => _, _}

import typings.reactLib.ScalableSlinky._

import org.rebeam.tree.slinkify.Syntax._

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


  val stringView: FunctionalComponent[Cursor[String]] = new ViewPC[String] {
    private val logger = getLogger

    override def apply(c: Cursor[String])(implicit tx: ReactTransactor): ReactElement = {

      logger.debug(s"stringView applying from $a, transactor $tx")

      // Editing the value is straightforward - just call set on the cursor. The cursor
      // creates a ValueDelta that will set the String directly to a new value, makes
      // a Transaction from the delta using the context provided by the cursor, and
      // then uses the implicit ReactTransactor to convert the Transactor to a Callback
      // we can give to React.
      Input(
        InputProps(
          value = c.a,
          onChange = onInputValueChange(s => c.set(s).apply())
        )
      )

    }

  }.build()

  val stringOTView: FunctionalComponent[Cursor[OTList[Char]]] = new ViewPC[OTList[Char]] {
    private val logger = getLogger

    override def apply(c: Cursor[OTList[Char]])(implicit tx: ReactTransactor): ReactElement = {
      logger.debug(s"stringOTView applying from ${c.a}, transactor $tx")

      Input(
        InputProps(
//          placeholder = "Todo item",
          value = c.a.list.mkString,
          onChange = onInputValueChange(
            s => {
              val o = c.a.list
              val n = s.toList
              val d = Diff(o, n)
              println(s"'$o' -> '$n' by $d")
              c.delta(OTListDelta(d)).apply()
            }
          )
        )
      )

    }
  }.build()

  // A View accepting the Id of a TodoItem.
  // This is a View so that it can use ReactViewOps to create a cursor at the id to view/edit the TodoItem.
  // The view will be re-rendered whenever the data at the Id changes.
  val todoItemView: FunctionalComponent[Id[TodoItem]] = new View[Id[TodoItem]] {
    private val logger = getLogger

    def apply[F[_]: Monad](id: Id[TodoItem])(implicit v: ReactViewOps[F], tx: ReactTransactor): F[ReactElement] = {
      logger.debug(s"View applying from $id")

      // By creating a cursor at the Id, we can enable navigation through the TodoItem
      v.cursorAt[TodoItem](id).map(
        cursor => {

          // We want to use a sui.Input directly below so we can pass in the checkbox as a label,
          // so we need to handle changes here
          val textCursor = cursor.zoom(TodoItem.text)

          Input(
            InputProps(
              placeholder = "Todo item",
              value = textCursor.a,
              onChange = onInputValueChange(s => textCursor.set(s).apply()),
              addonBefore = Switch(SwitchProps(
                size = typings.antdLib.antdLibStrings.small,
                checked = cursor.a.completed.isDefined,
                onChange = (b: Boolean, _) => cursor.delta(TodoItemCompletion(b)).apply()
              ))().toST,
            )
          )

        }
      )
    }
  }.build("todoItemView", onError = e => li(e.toString))

  // A View accepting the Id of a TodoItem.
  // This is a View so that it can use ReactViewOps to create a cursor at the id to view/edit the TodoItem.
  // The view will be re-rendered whenever the data at the Id changes.
  val todoListSummaryView: FunctionalComponent[Id[TodoList]] = new View[Id[TodoList]] {
    private val logger = getLogger

    def apply[F[_]: Monad](id: Id[TodoList])(implicit v: ReactViewOps[F], tx: ReactTransactor): F[ReactElement] = {
      logger.debug(s"View applying from $id")

      // By creating a cursor at the Id, we can enable navigation through the TodoItem
      v.cursorAt[TodoList](id).map(
        cursor => {

          // We want to use a sui.Input directly below so we can pass in the checkbox as a label,
          // so we need to handle changes here
          val textCursor = cursor.zoom(TodoList.name)
          stringOTView(textCursor)
        }
      )
    }
  }.build("todoItemView", onError = e => li(e.toString))

  // This component uses a child view for each item in the list, each of these will update only when the TodoItem
  // referenced by that Id changes.
  // Note that this does not need to be a View itself since it doesn't actually get the data by id - the child views
  // can still get data from the Context provided by dataProvider, so this can be a ViewP
  val todoListView: FunctionalComponent[TodoList] = new ViewP[TodoList] {
    override def apply(a: TodoList): ReactElement = {
      div(
        todoListSummaryView(a.id),
        div(
  //        verticalAlign = sui.List.VerticalAlign.Middle,
  //        relaxed = true: js.Any
        )(
          a.items.map(id => todoItemView(id).withKey(id.toString))
        )
      )
    }
  }.build

  // This component will manage and render an STM, initialised to the example data
  // We only use the index for data, so the model is Unit
  val dataProvider: FunctionalComponent[Unit] = LocalDataRoot[Unit, TodoIndex](
    (_, index) =>{
      println("LocalDataRootDemo dataProvider.render")
      div(
        // When we have an indexed TodoList, display it
        index.todoList.map[ReactElement](l => todoListView(l)).getOrElse(span()("Empty"))
      )
    },
    todoIndexer,  //This indexer will provide the most recently added list
    example       //This example Transaction populates the STM to display
  )

}
