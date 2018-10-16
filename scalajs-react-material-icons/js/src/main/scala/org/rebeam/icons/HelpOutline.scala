
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HelpOutline {

  @JSImport("@material-ui/icons/HelpOutline", JSImport.Default)
  @js.native
  object HelpOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HelpOutlineJS)
  
  def apply() = jsFnComponent()

}
    