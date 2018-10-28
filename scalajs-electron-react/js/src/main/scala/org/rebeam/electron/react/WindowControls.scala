
package org.rebeam.electron.react

import org.rebeam.{BrowserWindow, Electron}
import japgolly.scalajs.react._

import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ScalaCssReact._

object WindowControls {

  case class Props(disableMinimize: Boolean, disableMaximize: Boolean)

  case class State(win: Option[BrowserWindow], isMaximized: Boolean)

  class Backend(bs: BackendScope[Props, State]) {

    def handleMinimize(e: ReactEventFromInput): Callback =
      for {
        _ <- e.preventDefaultCB
        s <- bs.state
        _ <- Callback{s.win.foreach(w => w.minimize())}
      } yield ()

    def handleMaximize(e: ReactEventFromInput): Callback =
      for {
        _ <- e.preventDefaultCB
        s <- bs.state
        _ <- Callback{
          s.win.foreach(w => {
            if (w.isMaximizable()) {
              if (w.isMaximized()) {
                w.unmaximize()
              } else {
                w.maximize()
              }
            }
          })
        }
      } yield ()

    def handleClose(e: ReactEventFromInput): Callback =
      for {
        _ <- e.preventDefaultCB
        s <- bs.state
        _ <- Callback{s.win.foreach(_.close())}
      } yield ()

    def render(p: Props, s: State): VdomElement =
      <.div(Styles.windowControls)(

        <.button(
          Styles.windowControlsButtonPlain,
          ^.aria.label := "minimize", 
          ^.tabIndex := -1, 
          ^.disabled := p.disableMinimize,
          ^.onClick ==> handleMinimize
        )(
          TitleIcons.minimize
        ),

        <.button(
          Styles.windowControlsButtonPlain,
          ^.aria.label := "maximize", 
          ^.tabIndex := -1, 
          ^.disabled := p.disableMaximize,
          ^.onClick ==> handleMaximize
        )(
          if (s.isMaximized) TitleIcons.unmaximize else TitleIcons.maximize
        ),

        <.button(
          Styles.windowControlsButtonClose,
          ^.aria.label := "close", 
          ^.tabIndex := -1, 
          ^.onClick ==> handleClose
        )(
          TitleIcons.close
        )

      )

    val start: Callback = {
      val direct = bs.withEffectsImpure
      for {
        win <- CallbackTo(Electron.remote.getCurrentWindow())
        _ <- bs.setState(State(Some(win), win.isMaximized()))
        // TODO store listeners in state and remove on unmount
        _ <- Callback(win.addListener(eventName = "maximize", () => direct.modState(s => s.copy(isMaximized = true))))
        _ <- Callback(win.addListener(eventName = "unmaximize", () => direct.modState(s => s.copy(isMaximized = false))))
      } yield ()
    }

  }

  val WindowControls =
    ScalaComponent.builder[Props]("WindowControls")
      .initialState(State(None, isMaximized = false))
      .renderBackend[Backend]
      .componentDidMount(_.backend.start)
      .build

}