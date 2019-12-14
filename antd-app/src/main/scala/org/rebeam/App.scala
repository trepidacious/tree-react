package demo

import org.rebeam.LocalDataRootDemo
import slinky.core._
import slinky.core.annotations.react

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("antd/dist/antd.css", JSImport.Default)
@js.native
object CSS extends js.Any

@react object App {
  type Props = Unit

  private val css = CSS

  val component = FunctionalComponent[Props] { _ =>
    LocalDataRootDemo.dataProvider(())
  }
}
