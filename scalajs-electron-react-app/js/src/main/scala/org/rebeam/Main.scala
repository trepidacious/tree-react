package org.rebeam

import scalajs.js

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import scala.scalajs.js.annotation._
import org.rebeam.electron.react._

import org.rebeam.electron.react.CssSettings._
import scalacss.ScalaCssReact._

@JSExportTopLevel("Main")
object Main {

  val MainView =
    ScalaComponent.builder[String]("MainView")
      .render_P(name => <.div("Hello ", name))
      .build

  @JSExport
  def main(): Unit = {

    Styles.addToDocument()

    val theme = mui.styles.Styles.createMuiTheme(
      js.Dynamic.literal(
        "palette" -> js.Dynamic.literal(
          // "type" -> "dark"
        )
      )
    )

    // Render the top-level view to the predefined HTML div with id "App"
    // Note MuiThemeProvider should only have one child.
    mui.MuiThemeProvider(theme = theme: js.Any)(
      <.div(
        ^.className := "mainDiv",
        TitleBar(icon = Some(Node.relativePath("../assets/icons/png/small_icon_32.png")))(
          Title("Electron Demo")
        ),

        <.div(
          ^.margin := "20px",
          MultiSelectDemo.component(MultiSelectDemo.Props(MultiSelectDemo.countries)),
        // DownshiftMultiDemo.ctor(DownshiftMultiDemo.Props(DownshiftDemo.countries))
        // MainView("World")
        // DownshiftDemo.ctor(DownshiftDemo.Props(DownshiftDemo.countries))
          TextFieldDemo.ctor(),
          mui.Card(component = "div":js.Any, raised = true, elevation = 1.0)(<.span("Hi!"))
        )
      )
    ).renderIntoDOM(dom.document.getElementById("App"))

    ()
  }
}
