package org.rebeam

import scalajs.js
import japgolly.scalajs.react.vdom.html_<^._

object Darkness {
  val theme = mui.styles.Styles.createMuiTheme(
    js.Dynamic.literal(
      "palette" -> js.Dynamic.literal(
        "type" -> "dark"
      )
    )
  )

  def apply(children: VdomNode *) = mui.MuiThemeProvider(theme = theme: js.Any)(children: _*)
}