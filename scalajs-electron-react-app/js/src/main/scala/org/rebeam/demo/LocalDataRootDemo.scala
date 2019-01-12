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
import org.rebeam.mui

import scala.scalajs.js
import js.JSConverters._

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

  // This view shows a "monolithic" approach to displaying the list,
  // where we retrieve all the items using get, and display them in one component.
  // This will update whenever the TodoList or any item in it changes.
  val todoListViewMonolithic: Component[TodoList, Unit, Unit, CtorType.Props] = new View[TodoList] {
    def apply[F[_]: Monad](l: TodoList)(implicit v: ReactViewOps[F], tx: ReactTransactor): F[VdomElement] = {
      import v._

      // TODO add an implicit method (not sure of best name?) to call traverse(get)
      // l.items is a List[Id[TodoItem]]. get(id) gives an F[TodoItem], so l.items.map(get) would give a
      // List[F[TodoItem]]. Therefore instead of map we can call traverse, and get the result "inside-out", as
      // an F[List[TodoItem]]
      l.items.traverse(get)
        // We can then map this F[List[TodoItem]] to an F[VdomElement], using the normal approaches we would use
        // from a List to a VdomElement in scalajs-react - in this case toTagMod to produce a TagMod containing
        // a <li> for each TodoItem.
        .map(
          items =>
            <.ol(
              items.toTagMod(item => <.li(item.toString))
            )
        )
    }
  }.build("todoListView")

  val stringView: Component[Cursor[String], Unit, Unit, CtorType.Props] = new ViewPC[String] {
    override def apply(a: Cursor[String])(implicit tx: ReactTransactor): VdomNode = {

      // Editing the value is straightforward - just call set on the cursor. The cursor
      // creates a ValueDelta that will set the String directly to a new value, makes
      // a Transaction from the delta using the context provided by the cursor, and
      // then uses the implicit ReactTransactor to convert the Transactor to a Callback
      // we can give to React.
      
      // Note we can use e.target.value directly - set accepts a plain value, not a function,
      // so we don't have to worry about the event being reused. Of course the Callback produced
      // will not be used until later.
      def onChange(e: ReactEventFromInput) = a.set(e.target.value)

      mui.TextField(
        // Display the data from the cursor
        value = a.a,
        onChange = e => onChange(e)
      )
    }

  }.build("stringView")

  val todoItemView: Component[Id[TodoItem], Unit, Unit, CtorType.Props] = new View[Id[TodoItem]] {
    def apply[F[_]: Monad](id: Id[TodoItem])(implicit v: ReactViewOps[F], tx: ReactTransactor): F[VdomElement] = {
      // By creating a cursor at the Id, we can enable navigation through the TodoItem
      v.cursorAt[TodoItem](id).map(
        cursor => <.li(
          cursor.a.toString,

          // Zoom to the item's text, and we can edit it with a general-purpose ViewPC[String]
          stringView(cursor.zoom(TodoItem.text)),

          mui.Checkbox(
            value = cursor.a.completed.map(_.toString).orUndefined,
            checked = cursor.a.completed.isDefined: js.Any,
            onChange = (e: ReactEvent) => {
              val c =e.target.asInstanceOf[js.Dynamic].checked.asInstanceOf[Boolean]
              cursor.delta(TodoItemCompletion(c))
            }
          )
        )
      )
    }
  }.build("todoItemView")

  // This component uses a child view for each item in the list, each of these will update only when the TodoItem
  // referenced by that Id changes.
  // Note that this does not need to be a View itself since it doesn't actually get the data by id - the child views
  // can still get data from the Context provided by dataProvider, so this can be a ViewP
  val todoListView: Component[TodoList, Unit, Unit, CtorType.Props] = new ViewP[TodoList] {
    override def apply(a: TodoList): VdomNode =
      <.ol(
        a.items.toTagMod(id => todoItemView(id))
      )
  }.build("todoListView")


  // This component will manage and render an STM, initialised to the example data
  val dataProvider = LocalDataRoot.component[Unit, TodoIndex](
    (_, index) =>
      <.div(
        // When we have an indexed TodoList, display it
        index.todoList.whenDefined(todoListView(_))
      )
  )(
    todoIndexer,
    example
  )

}
