package org.rebeam

import scalajs.js
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.rebeam.ElectronUtils.DialogFileFilter
import org.scalajs.dom

import scala.scalajs.js.annotation._
import org.rebeam.electron.react._
import org.rebeam.electron.react.CssSettings._
import scalacss.ScalaCssReact._
import japgolly.scalajs.react._
import org.rebeam.tree.react.DataContext

import org.log4s._

@JSExportTopLevel("Main")
object Main {

  def initLogging(): Unit = {
    import Log4sConfig._

    /* Set `org.log4s.foo` and any children to log only Info or higher */
    setLoggerThreshold("org.rebeam", Info)

    /* Log nothing */
//    setLoggerThreshold("", OffThreshold)

    /* Set `org.log4s` to not log anything. This will not override the specific
     * setting we already applied to `org.log4s.foo`. */
//    setLoggerThreshold("org.log4s", OffThreshold)

    /* Set to log everything */
//    setLoggerThreshold("", AllThreshold)

    /* Unset a previously customized threshold. *Now* this category will inherit
     * from the parent level, which we disabled. */
//    resetLoggerThreshold("org.log4s.foo")

    /* Add a custom appender */
//    val myAppender = { ev: log4sjs.LoggedEvent => ??? }
    /* Add a custom appender, leaving others in place */
//    addLoggerAppender("org.example", myAppender)

    /* Set the specific appenders. The `additive` parameter controls whether
     * this is in addition to the appenders of the parent logger. The `false`
     * here means to *not* include any parent appenders. */
//    setLoggerAppenders("org.log4s.audit", false, Seq(myAppender))

    /* The `true` here means that myAppender` from the `audit` logger will still
     * be called since it allows additive inheritance. */
//    val appender2 = { ev: log4sjs.LoggedEvent => ??? }
//    setLoggerAppenders("org.log4s.audit.detailed", true, Seq(appender2))

    /* Resets the logger to default settings. This also adjusts the
     * `org.log4s.audit.detailed` appenders, since that logger inherits
     * appenders from its parents */
//    resetLoggerAppenders("org.log4s.audit")
  }


  @JSExport
  def main(): Unit = {

    initLogging()

    Styles.addToDocument()

    val theme = mui.styles.Styles.createMuiTheme(
      js.Dynamic.literal(
        "palette" -> js.Dynamic.literal(
          // "type" -> "dark"
          "typography" -> js.Dynamic.literal(
            "useNextVariants" -> true
          )
        )
      )
    )

    // Render the top-level view to the predefined HTML div with id "App"
    // Note MuiThemeProvider should only have one child.
    mui.MuiThemeProvider(theme = theme: js.Any)(
      <.div(
        ^.className := "mainDiv",
        TitleBar(icon = Some(Node.relativePath("../build/icons/small_icon_32.png")))(
          Title("Electron Demo")
        ),

        <.div(
          ^.margin := "20px",
          MultiSelectDemo.component(MultiSelectDemo.Props(MultiSelectDemo.countries)),

//          provider(1234),

          DataContext.dataProvider(),

          mui.Button(onClick = (e: ReactMouseEvent) => Callback{
            println(
              ElectronUtils.showOpenDialog(
                title = "Select file to print",
                buttonLabel = "Print",
                filters = List(
                  DialogFileFilter("Text file", List("txt"))
                ),
                properties = Set(ElectronUtils.MultiSelections, ElectronUtils.OpenFile),
                message = "Example message"
              )
            )
          })("Show open dialog"),

          mui.Button(onClick = (e: ReactMouseEvent) => Callback{
            ElectronUtils.showOpenDialogAsync(
              title = "Select file to print",
              buttonLabel = "Print",
              filters = List(
                DialogFileFilter("Text file", List("txt"))
              ),
              properties = Set(ElectronUtils.MultiSelections, ElectronUtils.OpenFile),
              message = "Example message",
              callback = filenames => println(filenames)
            )
          })("Show open dialog async"),
          NotificationSnackbar("notifications")
        // DownshiftMultiDemo.ctor(DownshiftMultiDemo.Props(DownshiftDemo.countries))
        // MainView("World")
        // DownshiftDemo.ctor(DownshiftDemo.Props(DownshiftDemo.countries))
        //  TextFieldDemo.ctor(),
        //  mui.Card(component = "div":js.Any, raised = true, elevation = 1.0)(<.span("Hi!"))
        )
      )
    ).renderIntoDOM(dom.document.getElementById("App"))

    ()
  }
}
