package org.rebeam

import cats.Monad
import cats.implicits._
import org.rebeam.TodoData._
import org.rebeam.tree.MapStateSTM.StateDelta
import org.rebeam.tree._
import org.rebeam.tree.slinkify._

import slinky.core._
import slinky.web.html._

import slinky.core.facade.ReactElement
import typings.antd.components.{List => AntList, _}
import typings.antd.antdStrings

import slinky.web.html._

// import StringOTView._
import typings.antd.menuMod.MenuMode
import typings.antd.menuContextMod.MenuTheme
import org.scalablytyped.runtime.StringDictionary

import scala.scalajs.js
import js.JSConverters._
import typings.antDesignIcons.components.PlusCircleFilled

import org.rebeam.tree.slinkify.Implicits._
import typings.antDesignIcons.components.MinusCircleFilled
import typings.antd.antdStrings.vertical
import typings.antd.paginationPaginationMod.PaginationConfig

object LocalDataRootDemo {

  // A View accepting the Id of a TodoItem.
  // This is a View so that it can use ReactViewOps to create a cursor at the id to view/edit the TodoItem.
  // The view will be re-rendered whenever the data at the Id changes.
  val todoItemView: FunctionalComponent[Id[TodoItem]] = new View[Id[TodoItem]] {

    def apply[F[_]: Monad](id: Id[TodoItem])(implicit v: ReactViewOps[F], tx: ReactTransactor): F[ReactElement] = {
      scribe.debug(s"View applying from $id")

      // By creating a cursor at the Id, we can enable navigation through the TodoItem
      v.cursorAt[TodoItem](id).map(
        cursor => {

          // We want to use a sui.Input directly below so we can pass in the checkbox as a label,
          // so we need to handle changes here
          val textCursor = cursor.zoom(TodoItem.text)

          Input(
            addonBefore = Switch(
              size = antdStrings.small,
              onChange = (b: Boolean, _) => cursor.delta(TodoItemCompletion(b)).apply()
            )(
              checked := cursor.a.completed.isDefined
            ),
          )(
            placeholder := "Todo item",
            value := textCursor.a,
            onChange := (event => textCursor.set(event.target.value).apply()),
            className := "todo-item"
          )
        }
      )
    }
  }.build("todoItemView", onError = e => li(e.toString))

  // A View accepting the Id of a TodoItem.
  // This is a View so that it can use ReactViewOps to create a cursor at the id to view/edit the TodoItem.
  // The view will be re-rendered whenever the data at the Id changes.
  val todoListSummaryView: FunctionalComponent[Id[TodoList]] = new View[Id[TodoList]] {

    def apply[F[_]: Monad](id: Id[TodoList])(implicit v: ReactViewOps[F], tx: ReactTransactor): F[ReactElement] = {
      scribe.debug(s"View applying from $id")

      // By creating a cursor at the Id, we can enable navigation through the TodoItem
      v.cursorAt[TodoList](id).map(
        cursor => {
          val textCursor = cursor.zoom(TodoList.name)
          // div(
          //   p(stringOTView(textCursor)),
          //   p(stringOTView(textCursor)),
            Space(
              Button(shape = antdStrings.round, `type` = antdStrings.primary, icon = PlusCircleFilled.plain, onClick = _ => cursor.delta(TodoListAdd("New todo")).apply())("Add todo"),
              Button(shape = antdStrings.round, icon = MinusCircleFilled.plain, onClick = _ => cursor.delta(TodoListClearCompleted()).apply())("Clear completed")
            )
          // )
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
      Space(
        direction = vertical
      )(
        todoListSummaryView(a.id),
        AntList[Id[TodoItem]](pagination = PaginationConfig(), dataSource = a.items.toJSArray, renderItem = (id: Id[TodoItem], index: Double) => todoItemView(id).withKey(id.toString))
        // a.items.map(id => todoItemView(id).withKey(id.toString))
      )
    }
  }.build

  val layoutView: FunctionalComponent[TodoList] = new ViewP[TodoList] {
    override def apply(a: TodoList): ReactElement = {
      // div()
      Layout(_overrides = StringDictionary("className" -> "layout"))(
        LayoutHeader()(
          Menu(mode = MenuMode.horizontal, theme = MenuTheme.dark, defaultSelectedKeys = js.Array("1"))(
            MenuItem().withKey("1")("Home"),
            // MenuItem().withKey("2")("Projects"),
            // MenuItem().withKey("3")("Blog")
          )
        ),
        LayoutContent()(
          PageHeader(title = "Demo", subTitle = "Shows OT String editing and simple todo view")(
            todoListView(a)
          )
        )
      )
    }

  }.build

  // When creating a LocalDataRoot to manage an STM, we need an Indexer that will give us an
  // index into the data - a way to get the Id of useful data. Otherwise we wouldn't know the
  // Id of any data in the STM, since Transactions do not return values (at the moment). 
  // We can then navigate to other data from the index and Refs.
  //
  // Our example index is simple - just store the most recently added TodoList.
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

  // This component will manage and render an STM, initialised to the example data
  // We only use the index for data, so the model is Unit
  val dataProvider: FunctionalComponent[Unit] = LocalDataRoot[Unit, TodoIndex](
    (_, index) =>{
      scribe.debug("LocalDataRootDemo dataProvider.render")
      // layoutView("Hello")
      // When we have an indexed TodoList, display it
      index.todoList.map[ReactElement](l => layoutView(l)).getOrElse(span()("Empty"))
    },
    todoIndexer,  //This indexer will provide the most recently added list
    example       //This example Transaction populates the STM to display
  )

}
