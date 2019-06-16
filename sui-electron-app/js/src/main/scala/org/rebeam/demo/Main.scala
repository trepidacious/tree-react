package org.rebeam.demo

import org.rebeam._

import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

import org.rebeam.electron.react._
import org.rebeam.electron.react.CssSettings._
import scalacss.ScalaCssReact._

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

    Styles.addToDocument()

    <.div(
      ^.className := "mainDiv",
      TitleBar(icon = Some(Node.relativePath("../build/icons/small_icon_32.png")))(
        Title("Electron Demo")
      ),
      <.div(
        ^.padding := "1rem",
        LocalDataRootDemo.dataProvider(())
      )
    ).renderIntoDOM(dom.document.getElementById("App"))

    ()
  }
}
