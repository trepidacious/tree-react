package org.rebeam.demo

import org.rebeam._
import org.rebeam.react.EventCallback

//import scalajs.js
// import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
// import org.rebeam.ElectronUtils.DialogFileFilter
import org.scalajs.dom

import scala.scalajs.js.annotation._
import org.rebeam.electron.react._
import org.rebeam.electron.react.CssSettings._
import scalacss.ScalaCssReact._
// import japgolly.scalajs.react._
import org.rebeam.sui._

import org.log4s._

@JSExportTopLevel("Main")
object Main {

  def initLogging(): Unit = {
    import Log4sConfig._

    // Set `org.rebeam` and any children to log only Info or higher
    setLoggerThreshold("org.rebeam", Info)
//    setLoggerThreshold("org.rebeam", AllThreshold)
  }


  @JSExport
  def main(): Unit = {

    initLogging()

    Styles.addToDocument()

    // val theme = mui.styles.Styles.createMuiTheme(
    //   js.Dynamic.literal(
    //     "palette" -> js.Dynamic.literal(
    //       // "type" -> "dark"
    //     ),
    //     "typography" -> js.Dynamic.literal(
    //       "useNextVariants" -> true
    //     )
    //   )
    // )

    // // Render the top-level view to the predefined HTML div with id "App"
    // // Note MuiThemeProvider should only have one child.
    // mui.MuiThemeProvider(theme = theme: js.Any)(
    //   <.div(
    //     ^.className := "mainDiv",
    //     TitleBar(icon = Some(Node.relativePath("../build/icons/small_icon_32.png")))(
    //       Title("Electron Demo")
    //     ),

    //     <.div(
    //       ^.margin := "20px",
    //       MultiSelectDemo.component(MultiSelectDemo.Props(MultiSelectDemo.countries)),

    //       LocalDataRootDemo.dataProvider(()),

    //       mui.Button(onClick = (e: ReactMouseEvent) => Callback{
    //         println(
    //           ElectronUtils.showOpenDialog(
    //             title = "Select file to print",
    //             buttonLabel = "Print",
    //             filters = List(
    //               DialogFileFilter("Text file", List("txt"))
    //             ),
    //             properties = Set(ElectronUtils.MultiSelections, ElectronUtils.OpenFile),
    //             message = "Example message"
    //           )
    //         )
    //       })("Show open dialog"),

    //       mui.Button(onClick = (e: ReactMouseEvent) => Callback{
    //         ElectronUtils.showOpenDialogAsync(
    //           title = "Select file to print",
    //           buttonLabel = "Print",
    //           filters = List(
    //             DialogFileFilter("Text file", List("txt"))
    //           ),
    //           properties = Set(ElectronUtils.MultiSelections, ElectronUtils.OpenFile),
    //           message = "Example message",
    //           callback = filenames => println(filenames)
    //         )
    //       })("Show open dialog async"),
    //       NotificationSnackbar("notifications")
    //     // DownshiftMultiDemo.ctor(DownshiftMultiDemo.Props(DownshiftDemo.countries))
    //     // MainView("World")
    //     // DownshiftDemo.ctor(DownshiftDemo.Props(DownshiftDemo.countries))
    //     //  TextFieldDemo.ctor(),
    //     //  mui.Card(component = "div":js.Any, raised = true, elevation = 1.0)(<.span("Hi!"))
    //     )
    //   )
    // ).renderIntoDOM(dom.document.getElementById("App"))

    // ()

    val onClick = EventCallback{println("Clicked")}

    <.div(
      ^.className := "mainDiv",
      TitleBar(icon = Some(Node.relativePath("../build/icons/small_icon_32.png")))(
        Title("Electron Demo")
      ),
      Button(onClick = onClick)("Click me!")
    ).renderIntoDOM(dom.document.getElementById("App"))

    ()
  }
}
