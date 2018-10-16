
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatIndentIncrease {

  @JSImport("@material-ui/icons/FormatIndentIncrease", JSImport.Default)
  @js.native
  object FormatIndentIncreaseJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatIndentIncreaseJS)
  
  def apply() = jsFnComponent()

}
    