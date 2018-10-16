
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatPaint {

  @JSImport("@material-ui/icons/FormatPaint", JSImport.Default)
  @js.native
  object FormatPaintJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatPaintJS)
  
  def apply() = jsFnComponent()

}
    