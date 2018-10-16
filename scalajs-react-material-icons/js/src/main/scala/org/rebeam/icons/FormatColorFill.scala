
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatColorFill {

  @JSImport("@material-ui/icons/FormatColorFill", JSImport.Default)
  @js.native
  object FormatColorFillJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatColorFillJS)
  
  def apply() = jsFnComponent()

}
    