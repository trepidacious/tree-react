
package org.rebeam

import japgolly.scalajs.react._
import scalajs.js

import japgolly.scalajs.react.vdom.html_<^._

object TitleBar {

  val TitleBar =
    ScalaComponent.builder[String]("TitleBar")
      .render_P(p => {
        <.div(
          ^.style := js.Dynamic.literal(
            "WebkitAppRegion" -> "drag"
          ),
          ^.height := "22px",
          ^.width := "100%",
          ^.backgroundColor := "#2e3b84"
        )
      })
      .build

}