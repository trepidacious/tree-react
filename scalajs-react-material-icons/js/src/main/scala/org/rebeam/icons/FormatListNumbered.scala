
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatListNumbered {

  @JSImport("@material-ui/icons/FormatListNumbered", JSImport.Default)
  @js.native
  object FormatListNumberedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatListNumberedJS)
  
  def apply() = jsFnComponent()

}
    