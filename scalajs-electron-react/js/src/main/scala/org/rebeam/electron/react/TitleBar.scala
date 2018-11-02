
package org.rebeam.electron.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.vdom.html_<^._
import org.rebeam.ElectronUtils
import scalacss.ScalaCssReact._

object TitleBar {

  case class Props(disableMinimize: Boolean = false, disableMaximize: Boolean = false, icon: Option[String] = None)

  val component =
    ScalaComponent.builder[Props]("TitleBar")
      .render_PC{case (p, c) => {

        val o = ElectronUtils.isOSXWithHiddenTitleBarSupport

        <.div(
          if (o) Styles.titlebarOSX else Styles.titlebarWindows
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
          ).when(!o),

          <.div(
            Styles.titleBarPaddingOSX
          ).when(o),

          c,

          //TODO add a resizeHandleRight on OSX
          //TODO replace icon with padding div on OSX so children don't interfere with controls (plus padding on right so title is centered?)
          //TODO Make Title adapt to OSX by centering and using apple system font?

          WindowControls.WindowControls(WindowControls.Props(p.disableMinimize, p.disableMaximize)).when(!o)
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
