
package org.rebeam.electron.react

import org.rebeam.{BrowserWindow, Electron}
import japgolly.scalajs.react._
// import scalajs.js

import japgolly.scalajs.react.vdom.html_<^._

// import scalacss.ScalaCssReact._

object WindowControls {

  case class Props(disableMinimize: Boolean, disableMaximize: Boolean)

  case class State(win: Option[BrowserWindow], isMaximized: Boolean)

  class Backend(bs: BackendScope[Props, State]) {

    def handleMinimize(e: ReactEventFromInput) =
      for {
        _ <- e.preventDefaultCB
        s <- bs.state
        _ <- Callback{s.win.foreach(w => w.minimize())}
      } yield ()

    def handleMaximize(e: ReactEventFromInput) =
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

    def handleClose(e: ReactEventFromInput) =
      for {
        _ <- e.preventDefaultCB
        s <- bs.state
        _ <- Callback{s.win.foreach(_.close())}
      } yield ()

    def render(p: Props, s: State): VdomElement =
      <.div(^.className := "window-controls")(

        <.button(
          ^.aria.label := "minimize", 
          ^.tabIndex := -1, 
          ^.className := "window-control window-minimize", 
          ^.disabled := p.disableMinimize,
          ^.onClick ==> handleMinimize
        )(
          TitleIcons.minimize
        ),

        <.button(
          ^.aria.label := "maximize", 
          ^.tabIndex := -1, 
          ^.className := "window-control window-maximize", 
          ^.disabled := p.disableMaximize,
          ^.onClick ==> handleMaximize
        )(
          if (s.isMaximized) TitleIcons.unmaximize else TitleIcons.maximize
        ),

        <.button(
          ^.aria.label := "close", 
          ^.tabIndex := -1, 
          ^.className := "window-control window-close",
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
        _ <- Callback(win.addListener("maximize", () => direct.modState(s => s.copy(isMaximized = true))))
        _ <- Callback(win.addListener("unmaximize", () => direct.modState(s => s.copy(isMaximized = false))))
      } yield ()
    }
  }

  val WindowControls = ScalaComponent.builder[Props]("WindowControls")
    .initialStateFromProps(p => State(None, false))
    .renderBackend[Backend]  // ← Use Backend class and backend.render
    .componentDidMount(_.backend.start)
    .build

}