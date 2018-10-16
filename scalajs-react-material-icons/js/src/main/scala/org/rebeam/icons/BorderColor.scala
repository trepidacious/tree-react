
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BorderColor {

  @JSImport("@material-ui/icons/BorderColor", JSImport.Default)
  @js.native
  object BorderColorJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BorderColorJS)
  
  def apply() = jsFnComponent()

}
    