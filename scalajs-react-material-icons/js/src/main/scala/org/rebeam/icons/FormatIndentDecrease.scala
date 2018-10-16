
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatIndentDecrease {

  @JSImport("@material-ui/icons/FormatIndentDecrease", JSImport.Default)
  @js.native
  object FormatIndentDecreaseJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatIndentDecreaseJS)
  
  def apply() = jsFnComponent()

}
    