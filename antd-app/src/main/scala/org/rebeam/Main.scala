package demo

import org.log4s.{Info, Log4sConfig}
import org.scalajs.dom
import slinky.web.ReactDOM

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("../../../../src/main/resources/index.css", JSImport.Namespace)
@js.native
object IndexCSS extends js.Object

object Main {

  def initLogging(): Unit = {
    import Log4sConfig._

    // Set `org.rebeam` and any children to log only Info or higher
    setLoggerThreshold("org.rebeam", Info)
    //    setLoggerThreshold("org.rebeam", AllThreshold)
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

