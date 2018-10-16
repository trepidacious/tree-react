
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BorderStyle {

  @JSImport("@material-ui/icons/BorderStyle", JSImport.Default)
  @js.native
  object BorderStyleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BorderStyleJS)
  
  def apply() = jsFnComponent()

}
    