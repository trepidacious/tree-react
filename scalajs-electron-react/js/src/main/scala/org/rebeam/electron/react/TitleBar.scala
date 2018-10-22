
package org.rebeam.electron.react

import japgolly.scalajs.react._
// import scalajs.js

import japgolly.scalajs.react.vdom.html_<^._

// import scalacss.ScalaCssReact._

object TitleBar {

  case class Props(disableMinimize: Boolean = false, disableMaximize: Boolean = false)

  val TitleBar =
    ScalaComponent.builder[Props]("TitleBar")
      .render_P(p => {
        <.div(^.id := "electron-app-title-bar", ^.className := "electron-app-title-bar")(
          <.div(^.className := "resize-handle resize-handle-top"),
          <.div(^.className := "resize-handle resize-handle-left"),
          // {!!icon && <img className="icon" src={icon} />}
          // {!!menu && <MenuBar menu={menu} />}
          // {children}
          WindowControls.WindowControls(WindowControls.Props(p.disableMinimize, p.disableMaximize))
        )
      })
      .build

}