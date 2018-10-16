
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatColorReset {

  @JSImport("@material-ui/icons/FormatColorReset", JSImport.Default)
  @js.native
  object FormatColorResetJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatColorResetJS)
  
  def apply() = jsFnComponent()

}
    