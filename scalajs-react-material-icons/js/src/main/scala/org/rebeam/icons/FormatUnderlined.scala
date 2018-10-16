
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatUnderlined {

  @JSImport("@material-ui/icons/FormatUnderlined", JSImport.Default)
  @js.native
  object FormatUnderlinedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatUnderlinedJS)
  
  def apply() = jsFnComponent()

}
    