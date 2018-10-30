
package org.rebeam.electron.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Unmounted

import japgolly.scalajs.react.vdom.html_<^._

 import scalacss.ScalaCssReact._

object TitleBar {

  case class Props(disableMinimize: Boolean = false, disableMaximize: Boolean = false, icon: Option[String] = None)

  val component =
    ScalaComponent.builder[Props]("TitleBar")
      .render_PC{case (p, c) => {
        <.div(
          Styles.titlebar
        )(
          <.div(
            Styles.resizeHandle,
            Styles.resizeHandleTop
          ),

          <.div(
            Styles.resizeHandle,
            Styles.resizeHandleLeft
          ),


          p.icon.map(i =>
            <.img(
              Styles.icon,
              ^.src := i
            )
          ),

          c,

          WindowControls.WindowControls(WindowControls.Props(p.disableMinimize, p.disableMaximize))
        )
      }}
      .build

  def apply(
    disableMinimize: Boolean = false,
    disableMaximize: Boolean = false,
    icon: Option[String] = None)(children: VdomNode*): Unmounted[Props, Unit, Unit] = {
    component(Props(disableMinimize, disableMaximize, icon))(children: _*)
  }

}
