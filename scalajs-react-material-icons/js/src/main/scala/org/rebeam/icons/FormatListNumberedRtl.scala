
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatListNumberedRtl {

  @JSImport("@material-ui/icons/FormatListNumberedRtl", JSImport.Default)
  @js.native
  object FormatListNumberedRtlJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatListNumberedRtlJS)
  
  def apply() = jsFnComponent()

}
    