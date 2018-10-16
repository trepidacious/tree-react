
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatAlignJustify {

  @JSImport("@material-ui/icons/FormatAlignJustify", JSImport.Default)
  @js.native
  object FormatAlignJustifyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatAlignJustifyJS)
  
  def apply() = jsFnComponent()

}
    