
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatAlignRight {

  @JSImport("@material-ui/icons/FormatAlignRight", JSImport.Default)
  @js.native
  object FormatAlignRightJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatAlignRightJS)
  
  def apply() = jsFnComponent()

}
    