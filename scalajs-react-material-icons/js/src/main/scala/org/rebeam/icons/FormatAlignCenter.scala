
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatAlignCenter {

  @JSImport("@material-ui/icons/FormatAlignCenter", JSImport.Default)
  @js.native
  object FormatAlignCenterJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatAlignCenterJS)
  
  def apply() = jsFnComponent()

}
    