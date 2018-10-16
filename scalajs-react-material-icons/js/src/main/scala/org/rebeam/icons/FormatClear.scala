
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatClear {

  @JSImport("@material-ui/icons/FormatClear", JSImport.Default)
  @js.native
  object FormatClearJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatClearJS)
  
  def apply() = jsFnComponent()

}
    