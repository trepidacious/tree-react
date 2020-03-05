package org.rebeam.tree.slinkify

import cats.Monad
import cats.implicits._
import org.log4s.getLogger
import org.rebeam.tree.Delta.OTListDelta
import org.rebeam.tree.ot.{CursorUpdate, Diff, OTList, Operation}
import org.scalajs.dom.{Event, html}
import slinky.core.{AttrPair, FunctionalComponent, SyntheticEvent}
import slinky.core.facade.Hooks.useRef
import slinky.core.facade.ReactElement
import slinky.web.html.{div, input, onChange, span, value}

object StringOTView {

  /**
   * Component allowing viewing and editing of an OTList[Char] via a Cursor. This will edit using OTListDelta
   * reflecting a Diff of old and new input contents, whenever the input value changes.
   * In detail, this just passes the current String built from the OTList, the most recent CursorUpdate and
   * an edit function to a stringOTInnerView.
   */
  val stringOTView: FunctionalComponent[Cursor[OTList[Char]]] = new ViewC[OTList[Char]] {
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
  }.build("StringOTView")

  // This is an inner component used by stringOTView
  private case class InnerProps(s: String, edit: Operation[Char] => Unit, cursorUpdate: CursorUpdate[Char])
  private val stringOTInnerView: FunctionalComponent[InnerProps] = FunctionalComponent[InnerProps] {
    p => {

      // This contains the required cursor range to be set after a render, or null if no
      // range needs to be set.
      val requiredCursorRange = useRef[(Int, Int)](null)

      // This contains the currently displayed input, if we know it, null otherwise
      val inputRef = useRef[html.Input](null)

      // This contains the previous client rev we used to update cursor position, null if
      // we don't have a (reliable) revision for this. This is used to ensure we only update the
      // cursor if we see consecutive operations
      val previousClientRev = useRef[Int](null.asInstanceOf[Int])

      // A callback to do two things:
      // 1. Set inputRef to the rendered input.
      // 2. If there is a cursor range update (i.e. if requiredCursorRange ref is not null), set the
      //    input's selectionRange to that range, then clear requiredCursorRange.
      val inputCallback = ExtraHooks.useCallback[html.Input](
        input => {
          inputRef.current = input
          val rcr = requiredCursorRange.current
          if (input != null && rcr != null) {
            input.setSelectionRange(rcr._1, rcr._2)
            requiredCursorRange.current = null
          }
        },
        // This is a callback with no watchedObjects, since it should be quick, and will do nothing unless required
        Nil
      )

      // Respond to input changes by comparing the new input value to the string in our props
      // string, deriving a Diff that will update our props string to the new input value,
      // and using the edit callback in props to apply the Diff
      def handleChange(e: SyntheticEvent[html.Input, Event]): Unit = {
        val s = e.target.value
        val o = p.s.toList
        val n = s.toList
        val d = Diff(o, n)
        p.edit(d)
      }

      // Get the client revision from previous render (if any - will be null otherwise) and the
      // current revision from the cursor update we are rendering. Then store the current rev as
      // the previous rev, for next render cycle
      val previousRev = previousClientRev.current
      val currentRev = p.cursorUpdate.clientRev
      previousClientRev.current = currentRev
      println(s"Revs $previousRev => $currentRev")

      // TODO track client rev in case we fall out of sync
      // If we have a current input (i.e. a previously-rendered input dom component), update our required cursor
      // range ref - this will cause the input to have its selection range updated when rendering is complete. This
      // is the only effect of the foreach
      val currentInput = scala.Option(inputRef.current)
      val newValue = p.s
      currentInput.foreach(
        i => {
          // Get the value (text string) currently displayed in the input
          val oldValue = i.value
          println(s"Rendering with a current input, '$oldValue' -> '$newValue'...")

          // We only need to update the selection if the value has changed.
          if (oldValue != newValue) {
            println("  Updated value - must not be our change.")

            // The cursor update tells us the most recent local update, and we can use this to update the
            // input's old selection range to the required new one
            p.cursorUpdate.previousLocalUpdate.foreach(upd => {
              // The input that is actually editing the value skips this logic since
              // the input control updates its own cursor position, so this only runs with isEditor = false.
              // We can update a selection index by using the update's operation to transform it.
              def update(index: Int) = upd.op.transformCursor(index, isEditor = false)

              // Get current selection range, and update the start and end indices using the update function
              // to give the next selection range (reflecting the most recent operation applied to the text)
              val current = (i.selectionStart, i.selectionEnd)
              val next = current.bimap(update, update)

              // We always update the cursor range range (even if it has not changed, for example when the operation
              // only makes changes after the selection) - otherwise it will set itself to the end of the input
              // automatically (this is how an input responds to having a new value string set).
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

}
