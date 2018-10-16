
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Scanner {

  @JSImport("@material-ui/icons/Scanner", JSImport.Default)
  @js.native
  object ScannerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ScannerJS)
  
  def apply() = jsFnComponent()

}
    