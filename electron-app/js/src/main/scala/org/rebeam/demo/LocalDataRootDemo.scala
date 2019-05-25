package org.rebeam.demo

import cats.Monad
import cats.implicits._
import org.rebeam.tree.MapStateSTM.StateDelta
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Component
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.vdom.{html_<^, _}
import org.rebeam.tree._
import org.rebeam.tree.react._
import TodoData._
import org.log4s.getLogger
import org.rebeam.mui
import org.rebeam._
import org.rebeam.tree.Delta.OTListDelta
import org.rebeam.tree.ot.{Diff, OTList}

import scala.scalajs.js
import js.JSConverters._
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

//  // This view shows a "monolithic" approach to displaying the list,
//  // where we retrieve all the items using get, and display them in one component.
//  // This will update whenever the TodoList or any item in it changes.
//  val todoListViewMonolithic: Component[TodoList, Unit, Unit, CtorType.Props] = new View[TodoList] {
//    def apply[F[_]: Monad](l: TodoList)(implicit v: ReactViewOps[F], tx: ReactTransactor): F[VdomElement] = {
//      import v._
//
//      // TODO add an implicit method (not sure of best name?) to call traverse(get)
//      // l.items is a List[Id[TodoItem]]. get(id) gives an F[TodoItem], so l.items.map(get) would give a
//      // List[F[TodoItem]]. Therefore instead of map we can call traverse, and get the result "inside-out", as
//      // an F[List[TodoItem]]
//      l.items.traverse(get)
//        // We can then map this F[List[TodoItem]] to an F[VdomElement], using the normal approaches we would use
//        // from a List to a VdomElement in scalajs-react - in this case toTagMod to produce a TagMod containing
//        // a <li> for each TodoItem.
//        .map(
//          items =>
//            <.ol(
//              items.toTagMod(item => <.li(item.toString))
//            )
//        )
//    }
//  }.build("todoListView")

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
      def onChange(e: ReactEventFromInput) = {
        val o = a.a
        val n = e.target.value
        val d = Diff(o.toList, n.toList)
        println(s"'$o' -> '$n' by $d")
        a.set(e.target.value)
      }

//      mui.TextField(
//        // Display the data from the cursor
//        value = a.a,
//        onChange = e => onChange(e)
//      )

      <.input(
        ^.value := a.a,
        ^.onChange ==> onChange,
        ^.margin := "10px"
      )
    }

  }.build("stringView")

  val stringOTView: Component[Cursor[OTList[Char]], Unit, Unit, CtorType.Props] = new ViewPC[OTList[Char]] {
    private val logger = getLogger

    override def apply(c: Cursor[OTList[Char]])(implicit tx: ReactTransactor): VdomNode = {
      logger.debug(s"stringOTView applying from ${c.a}, transactor $tx")


      // Diff the old and new contents of the input, as an operation,
      // and then apply this as an OTListDelta using the cursor
      def onChange(e: ReactEventFromInput) = {
        val o = c.a.list
        val n = e.target.value.toList
        val d = Diff(o, n)
        println(s"'$o' -> '$n' by $d")
        c.delta(OTListDelta(d))
      }
      
      <.input(
        ^.value := c.a.list.mkString,
        ^.onChange ==> onChange,
        ^.margin := "10px"
      )
    }

  }.build("stringView")

  val todoItemView: Component[Id[TodoItem], Unit, Unit, CtorType.Props] = new View[Id[TodoItem]] {
    private val logger = getLogger

    def apply[F[_]: Monad](id: Id[TodoItem])(implicit v: ReactViewOps[F], tx: ReactTransactor): F[VdomElement] = {
      logger.debug(s"View applying from $id")
      // By creating a cursor at the Id, we can enable navigation through the TodoItem
      v.cursorAt[TodoItem](id).map(
        cursor =>

//          mui.ListItem (
////            key=id.toString
////            role={undefined} dense button
//            dense = true,
////            button = true,
////            onClick = (e: ReactEvent) =>
////              cursor.delta(TodoItemCompletion(cursor.a.completed.isEmpty))
//          )(
//            mui.Checkbox(
//              value = cursor.a.completed.map(_.toString).orUndefined,
//              checked = cursor.a.completed.isDefined: js.Any,
//              onChange = (e: ReactEvent, checked: Boolean) =>
//                cursor.delta(TodoItemCompletion(checked))
//            ),
//
//
////            mui.ListItemText()(stringView(cursor.zoom(TodoItem.text))),
//
//            stringView(cursor.zoom(TodoItem.text))
//
////            mui.ListItemSecondaryAction()(
////              mui.IconButton(
////                //                  aria-label="Comments"
////              )(
////                icons.Edit()
////              )
////            )
//          )


          <.li(
//              ^.margin := "10px",
//              ^.backgroundColor := "#aaa",
            mui.Checkbox(
              value = cursor.a.completed.map(_.toString).orUndefined,
              checked = cursor.a.completed.isDefined: js.Any,
              onChange = (e: ReactEvent, checked: Boolean) =>
                cursor.delta(TodoItemCompletion(checked))
            ),

            // Zoom to the item's text, and we can edit it with a general-purpose ViewPC[String]
            stringView(cursor.zoom(TodoItem.text)),
          )

      )
    }
  }.build("todoItemView")

  // This component uses a child view for each item in the list, each of these will update only when the TodoItem
  // referenced by that Id changes.
  // Note that this does not need to be a View itself since it doesn't actually get the data by id - the child views
  // can still get data from the Context provided by dataProvider, so this can be a ViewP
  val todoListView: Component[TodoList, Unit, Unit, CtorType.Props] = new View[TodoList] {

    override def apply[F[_] : Monad](a: TodoList)(implicit v: ReactViewOps[F], tx: ReactTransactor): F[html_<^.VdomElement] = for {
      cName <- v.cursorAt(a.id)
    } yield {
      <.div(
        stringOTView(cName.zoom(TodoList.name)),
        stringOTView(cName.zoom(TodoList.name)),
        <.ul(
          a.items.toTagMod(id => todoItemView.withKey(id.toString)(id))
        )
      )
    }
//    override def apply(a: Cursor[TodoList])(implicit tx: ReactTransactor): VdomNode = ???

//    override def apply(a: TodoList): VdomNode =
//  //      mui.List(
//  //        dense = true
//  //      )(
//  //        // TODO make this neater
//  //        a.items.map(id => todoItemView.withKey(id.toString)(id): VdomNode): _*
//  //      )
//      <.div(
//        stringOTView(a.name),
//        stringOTView(a.name),
//        <.ul(
//          a.items.toTagMod(id => todoItemView.withKey(id.toString)(id))
//        )
//      )
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
