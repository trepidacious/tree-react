
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatColorText {

  @JSImport("@material-ui/icons/FormatColorText", JSImport.Default)
  @js.native
  object FormatColorTextJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatColorTextJS)
  
  def apply() = jsFnComponent()

}
    