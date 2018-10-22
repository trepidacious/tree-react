
package org.rebeam.electron.react

import japgolly.scalajs.react._
// import scalajs.js

import japgolly.scalajs.react.vdom.html_<^._

// import scalacss.ScalaCssReact._

object WindowControls {

  case class Props(disableMinimize: Boolean, disableMaximize: Boolean)

  case class State(isMaximized: Boolean)

  class Backend(bs: BackendScope[Props, State]) {
    def render(p: Props, s: State): VdomElement =
      <.div(^.className := "window-controls")(

        <.button(
          ^.aria.label := "minimize", 
          ^.tabIndex := -1, 
          ^.className := "window-control window-minimize", 
          ^.disabled := p.disableMinimize,
          // ^.onClick := {e => this.props.currentWindow.minimize()}
        )(
          TitleIcons.minimize
        ),

        <.button(
          ^.aria.label := "maximize", 
          ^.tabIndex := -1, 
          ^.className := "window-control window-maximize", 
          ^.disabled := p.disableMaximize,
          // onClick={e => this.props.currentWindow.isMaximizable() ? this.props.currentWindow.isMaximized() ? this.props.currentWindow.unmaximize() : this.props.currentWindow.maximize() : null}>
        )(
          if (s.isMaximized) TitleIcons.unmaximize else TitleIcons.maximize
        ),

        <.button(
          ^.aria.label := "close", 
          ^.tabIndex := -1, 
          ^.className := "window-control window-close", 
          // onClick={e => this.props.currentWindow.close()}>
        )(
          TitleIcons.close
        )

      )
  }

  val WindowControls = ScalaComponent.builder[Props]("WindowControls")
    .initialStateFromProps(p => State(false)) //TODO base on window in props, when we have this
    .renderBackend[Backend]  // ← Use Backend class and backend.render
    .build

}