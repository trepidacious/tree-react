
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatAlignLeft {

  @JSImport("@material-ui/icons/FormatAlignLeft", JSImport.Default)
  @js.native
  object FormatAlignLeftJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatAlignLeftJS)
  
  def apply() = jsFnComponent()

}
    