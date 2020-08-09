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

import slinky.web.html._

import typings.antd.antdStrings
import typings.antd.paginationPaginationMod.PaginationConfig

// import StringOTView._

import scala.scalajs.js
import js.JSConverters._
import typings.antd.menuContextMod.MenuTheme

import slinkify.API._
import ReactView._
import typings.react.mod.CSSProperties
import org.rebeam.tree.view.MaterialColor
import typings.rcMenu.interfaceMod.MenuMode

object LocalDataRootDemo {

  val avatarBg: CSSProperties = CSSProperties().setBackgroundColor(MaterialColor.BlueGrey(700).toString())
  val todoItemArcHashView: FunctionalComponent[Id[TodoItem]] = ArcHashView[Id[TodoItem]]
  val todoItemAvatar: FunctionalComponent[Id[TodoItem]] = ViewPure {
    id => todoItemArcHashView(id)
  } 




  // A View accepting the Id of a TodoItem.
  // This is a View so that it can use ReactViewOps to create a cursor at the id to view/edit the TodoItem.
  // The view will be re-rendered whenever the data at the Id changes.
  val todoItemView: FunctionalComponent[Id[TodoItem]] = View {

    // We need an implicit ReactTransactor here, hence the slightly unusual function to a function
    implicit tx => id => 
      // By creating a cursor at the Id, we can enable navigation through the TodoItem
      cursorAt[TodoItem](id).map(
        cursor => {

          val textCursor = cursor.zoom(TodoItem.text)

          val switch = Switch
            .size(antdStrings.small)
            .onChange(
              (b: Boolean, _) => cursor.delta(TodoItemCompletion(b)).apply()
            ).checked(cursor.a.completed.isDefined)

          // div(
          //   todoItemAvatar(id),
            Input
              .addonBefore(switch)
              .placeholder("Todo item")
              .value(textCursor.a)
              .onChange(
                event => textCursor.set(event.target_ChangeEvent.value).apply()
              ).className("todo-item")
          // )
        }
      )
    
  }

  // A View accepting the Id of a TodoItem.
  // This is a View so that it can use ReactViewOps to create a cursor at the id to view/edit the TodoItem.
  // The view will be re-rendered whenever the data at the Id changes.
  val todoListSummaryView: FunctionalComponent[Id[TodoList]] = View {

    implicit tx => id => {
      scribe.debug(s"View applying from $id")

      // By creating a cursor at the Id, we can enable navigation through the TodoItem
      cursorAt[TodoList](id).map(
        cursor => {
          val textCursor = cursor.zoom(TodoList.name)
          // div(
          //   p(stringOTView(textCursor)),
          //   p(stringOTView(textCursor)),
            Space(
              Button
                .shape(antdStrings.round)
                .`type`(antdStrings.primary)
                .onClick(
                  _ => cursor.delta(TodoListAdd("New todo")).apply()
                )("Add todo"),  //.icon(PlusCircleFilled())
              Button
                .shape(antdStrings.round)
                .onClick(
                  _ => cursor.delta(TodoListClearCompleted()).apply()
                )("Clear completed"), //.icon(MinusCircleFilled())
            )
          // )
        }
      )
    }
  }

  // This component uses a child view for each item in the list, each of these will update only when the TodoItem
  // referenced by that Id changes.
  // Note that this does not need to be a View itself since it doesn't actually get the data by id - the child views
  // can still get data from the Context provided by dataProvider, so this can be a ViewPure
  val todoListView: FunctionalComponent[TodoList] = ViewPure {
    a =>
      Space.direction(
        antdStrings.vertical
      )(
        todoListSummaryView(a.id),
        AntList[Id[TodoItem]]
          .pagination(PaginationConfig())
          .dataSource(a.items.toJSArray)
          .renderItem((id, index) => todoItemView(id).withKey(id.toString))
        // a.items.map(id => todoItemView(id).withKey(id.toString))
      )
  }

  val layoutView: FunctionalComponent[TodoList] = ViewPure {
    a =>
      // div()
      Layout.className("layout")(
        Layout.Header()(
          Menu
            .mode(MenuMode.horizontal)
            .theme(MenuTheme.dark)
            .defaultSelectedKeys(js.Array("1"))(
              MenuItem()
                .withKey("1")(
                  "Home"
                ),
              // MenuItem().withKey("2")("Projects"),
              // MenuItem().withKey("3")("Blog")
            )
        ),
        Layout.Content()(
          PageHeader
            .title("Demo")
            .subTitle("Shows OT String editing and simple todo view")(
              todoListView(a)
            )
        )
      )    
  }

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
      index.todoList.map[ReactElement](
        l => layoutView(l)
      ).getOrElse(
        span()("Empty")
      )
      // index.todoList.map[ReactElement](l => div("Hello World!")).getOrElse(span()("Empty"))
      // Alert
      //       .message("Alert message title")
      //       .description("Further details about the context of this alert.")
      //       .`type`(antdStrings.info)
      //       .showIcon(true)

    },
    todoIndexer,  //This indexer will provide the most recently added list
    example       //This example Transaction populates the STM to display
  )

}
