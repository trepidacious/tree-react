
package org.rebeam.electron.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.vdom.html_<^._
import org.rebeam.ElectronUtils
import scalacss.ScalaCssReact._
//import org.rebeam.mui.Typography
//import org.rebeam.mui.styles.Style

object Title {

  val component =
    ScalaComponent.builder[String]("Title")
      .render_P{
        p => {
          val o = ElectronUtils.isOSXWithHiddenTitleBarSupport
          <.div(
            if (o) Styles.titleOSX else Styles.title,
            //TODO move to Styles - not clear how to represent this without src values etc.
            ^.fontFamily := """-apple-system, BlinkMacSystemFont, "Segoe UI", "Roboto", "Oxygen", "Ubuntu", "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue", Arial, sans-serif"""
          )(
//          if (o) p else Typography(color = Typography.Color.Inherit, variant = Typography.Variant.Body2, style = Style("fontWeight" -> "300"))(p)
            p
          )
        }
      }
      .build

  def apply(text: String): Unmounted[String, Unit, Unit] = {
    component(text)
  }

}
