package org.rebeam

import cats.Monad
import cats.implicits._
import org.log4s.getLogger
import org.rebeam.TodoData._
import org.rebeam.tree.Delta.OTListDelta
import org.rebeam.tree.MapStateSTM.StateDelta
import org.rebeam.tree._
import org.rebeam.tree.ot.{CursorUpdate, Diff, OTList, Operation}
import org.rebeam.tree.slinkify._
import slinky.core.AttrPair

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import slinky.core.facade.ReactElement
//import slinky.core.facade.React
import typings.antdLib.AntdFacade.{List => _, _}
import typings.reactLib.ScalableSlinky._
import org.rebeam.tree.slinkify.Syntax._
import slinky.core.facade.Hooks._

import slinky.core.{FunctionalComponent, SyntheticEvent}
import slinky.web.html._
import org.scalajs.dom.{html, Event}


@js.native
@JSGlobal
class InputEvent extends js.Object {
  def dataTransfer: js.Any = js.native
  def getTargetRanges(): js.Any = js.native
}

object LocalDataRootDemo {

  private val logger = getLogger

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
//      logger.debug(s"stringOTView applying from ${c.a}, transactor $tx")

      Input(
        InputProps(
//          placeholder = "Todo item",
          value = c.a.list.mkString,
          onChange = onInputValueChange(
            s => {
              val o = c.a.list
              val n = s.toList
              val d = Diff(o, n)
              c.delta(OTListDelta(d)).apply()
            }
          )
        )
      )

    }
  }.build()

  val stringOTView2: FunctionalComponent[Cursor[OTList[Char]]] = new ViewC[OTList[Char]] {
    private val logger = getLogger

    override def apply[F[_] : Monad](c: Cursor[OTList[Char]])
      (implicit v: ReactViewOps[F], tx: ReactTransactor): F[ReactElement] = {

      import v._

//      logger.debug(s"stringOTView applying from ${c.a}, transactor $tx")

      for {
        u <- getOTListCursorUpdate(c.a)
      } yield {
        div()(
          span(s"${u.clientRev} ${u.previousLocalUpdate}"),
          Input(
            InputProps(
              //          placeholder = "Todo item",
              value = c.a.list.mkString,
              onChange = onInputValueChange(
                s => {
                  val o = c.a.list
                  val n = s.toList
                  val d = Diff(o, n)
                  c.delta(OTListDelta(d)).apply()
                }
              )
            )
          )
        )

      }
    }
  }.build("stringOTView2")

  val stringOTView3: FunctionalComponent[Cursor[OTList[Char]]] = new ViewC[OTList[Char]] {
    private val logger = getLogger

    override def apply[F[_] : Monad](c: Cursor[OTList[Char]])
                                    (implicit v: ReactViewOps[F], tx: ReactTransactor): F[ReactElement] = {

      import v._

//      logger.debug(s"stringOTView applying from ${c.a}, transactor $tx")

      def handleChange(e: SyntheticEvent[html.Input, Event]): Unit = {
        val s = e.target.value
        val o = c.a.list
        val n = s.toList
        val d = Diff(o, n)
        c.delta(OTListDelta(d)).apply()
      }

      for {
        u <- getOTListCursorUpdate(c.a)
      } yield {
        div()(
          span(s"${u.clientRev} ${u.previousLocalUpdate}"),
          input(
            value := c.a.list.mkString,
            onChange := (handleChange(_))
          )
        )

      }
    }
  }.build("stringOTView3")


  val stringOTView4: FunctionalComponent[Cursor[OTList[Char]]] = new ViewPC[OTList[Char]] {
    private val logger = getLogger

    override def apply(c: Cursor[OTList[Char]])(implicit tx: ReactTransactor): ReactElement = {
      //      logger.debug(s"stringOTView applying from ${c.a}, transactor $tx")

      //      val inputRef = useRef[html.Input](null)

      //      println("stringOTView 4 rendering")

      //      val (s, ss) = useState(0)

      val inputRef = useRef[html.Input](null)

      val inputCallback = ExtraHooks.useCallback[html.Input](input => {
        println(s">>>>>> ExtraHooks.useCallback($input)")
        inputRef.current = input
        if (input != null) input.setSelectionRange(2, 3)
      }, Nil)

      def handleChange(e: SyntheticEvent[html.Input, Event]): Unit = {
        println(s"${e.target.selectionStart} to ${e.target.selectionEnd}")  // Note this is the selection AFTER the change
        //        println(inputRef.current)
        val s = e.target.value
        val o = c.a.list
        val n = s.toList
        val d = Diff(o, n)
        c.delta(OTListDelta(d)).apply()
        //        ss(s => s+1)
      }

      val newValue = c.a.list.mkString
      val oldValue = if (inputRef.current != null) inputRef.current.value else null
      println(s"Rendering, '$oldValue' -> '$newValue'")

      // TODO if we are changing the value, update cursor. Can do this with an effect? Or maybe the callback can
      // read a required selection change from a ref?

      div(
        //        span(s),
        input(
          value := newValue,
          onChange := (handleChange(_)),
          new AttrPair[input.tag.type]("ref", inputCallback) // TODO work out how to do this using `:=`
        )
      )

    }
  }.build()

  val stringOTOuterView: FunctionalComponent[Cursor[OTList[Char]]] = new ViewC[OTList[Char]] {
    private val logger = getLogger

    override def apply[F[_] : Monad](c: Cursor[OTList[Char]])
                                    (implicit v: ReactViewOps[F], tx: ReactTransactor): F[ReactElement] = {
      import v._

      def edit(o: Operation[Char]): Unit =
        c.delta(OTListDelta(o)).apply()

      for {
        u <- getOTListCursorUpdate(c.a)
      } yield {
        stringOTInnerView(InnerProps(c.a.list.mkString, edit, u))
      }
    }
  }.build("stringOTOuterView")

  case class InnerProps(s: String, edit: Operation[Char] => Unit, cursorUpdate: CursorUpdate[Char])

  val stringOTInnerView: FunctionalComponent[InnerProps] = FunctionalComponent[InnerProps] {
    p => {
      val requiredCursorRange = useRef[(Int, Int)](null)

      val inputRef = useRef[html.Input](null)

      // Keep track of the input in inputRef, and apply required cursor range changes
      val inputCallback = ExtraHooks.useCallback[html.Input](input => {
        inputRef.current = input
        val rcr = requiredCursorRange.current
        if (input != null && rcr != null) {
          input.setSelectionRange(rcr._1, rcr._2)
          requiredCursorRange.current = null
        }
      }, Nil)

      def handleChange(e: SyntheticEvent[html.Input, Event]): Unit = {
        val s = e.target.value
        val o = p.s.toList
        val n = s.toList
        val d = Diff(o, n)
        p.edit(d)
      }

      val currentInput = scala.Option(inputRef.current)

      val newValue = p.s

      // TODO track client rev in case we fall out of sync
      currentInput.foreach(
        i => {
          val oldValue = i.value
          println(s"Rendering with a current input, '$oldValue' -> '$newValue'...")
          if (oldValue != newValue) {
            println("  Updated value - must not be our change.")
            p.cursorUpdate.previousLocalUpdate.foreach(u => {
              // Use isEditor false - the input that is actually editing the value skips this logic since
              // the input control updates its own cursor position
              def update(index: Int) = u.op.transformCursor(index, isEditor = false)
              val current = (i.selectionStart, i.selectionEnd)
              val next = current.bimap(update, update)

              // We always update the cursor range range - otherwise it will set itself to the end of the input
              // automatically
              requiredCursorRange.current = next
              if (next != current){
                println(s"  Selection should change from $current to $next")
              } else {
                println(s"  Selection stays at $current")
              }
            })
          }
        }
      )


      div(
        span(currentInput.map(i => s"${i.selectionStart} to ${i.selectionEnd}")),
        input(
          value := newValue,
          onChange := (handleChange(_)),
          new AttrPair[input.tag.type]("ref", inputCallback) // TODO work out how to do this using `:=`
        )
      )

    }
  }

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
          div(
            stringOTOuterView(textCursor),
            stringOTOuterView(textCursor)
          )
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
      logger.debug("LocalDataRootDemo dataProvider.render")
      div(
        // When we have an indexed TodoList, display it
        index.todoList.map[ReactElement](l => todoListView(l)).getOrElse(span()("Empty"))
      )
    },
    todoIndexer,  //This indexer will provide the most recently added list
    example       //This example Transaction populates the STM to display
  )

}
