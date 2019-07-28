package org.rebeam.demo

import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

import scalacss.ScalaCssReact._
import StyleSettings.CssSettings._

import org.log4s._

object Main {

  def initLogging(): Unit = {
    import Log4sConfig._

    // Set `org.rebeam` and any children to log only Info or higher
    setLoggerThreshold("org.rebeam", Info)
//    setLoggerThreshold("org.rebeam", AllThreshold)
  }

  def main(args: Array[String]): Unit = {
    println("Hello world!")

    initLogging()

    SUIStyles.addToDocument()

    <.div(
      ^.padding := "1rem",
      LocalDataRootDemo.dataProvider(())
    ).renderIntoDOM(dom.document.getElementById("App"))

    ()
  }
}
