
package org.rebeam.electron.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._
import org.rebeam.mui.Typography
import org.rebeam.mui.styles.Style

object Title {

  val component =
    ScalaComponent.builder[String]("Title")
      .render_P{ p =>
        <.div(
          Styles.title
        )(
          Typography(color = Typography.Color.Inherit, variant = Typography.Variant.Body2, style = Style("font-weight" -> "400"))(p)
        )
      }
      .build

  def apply(text: String): Unmounted[String, Unit, Unit] = {
    component(text)
  }

}
