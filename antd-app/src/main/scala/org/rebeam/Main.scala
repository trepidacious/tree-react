package demo

import org.scalajs.dom
import slinky.web.ReactDOM

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scribe.Level

@JSImport("./index.css", JSImport.Namespace)
@js.native
object IndexCSS extends js.Object

object Main {

  def initLogging(): Unit = {
    // Set all loggers to Info or higher
    scribe.Logger.root.clearHandlers().clearModifiers().withHandler(minimumLevel = Some(Level.Info)).replace()
  }

  def main(args: Array[String]): Unit = {
    initLogging()
    IndexCSS
    val container = Option(dom.document.getElementById("root")).getOrElse {
      val elem = dom.document.createElement("div")
      elem.id = "root"
      dom.document.body.appendChild(elem)
      elem
    }

    ReactDOM.render(App.component(()), container)

    ()
  }
}


