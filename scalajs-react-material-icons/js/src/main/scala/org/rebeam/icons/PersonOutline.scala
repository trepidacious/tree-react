
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PersonOutline {

  @JSImport("@material-ui/icons/PersonOutline", JSImport.Default)
  @js.native
  object PersonOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PersonOutlineJS)
  
  def apply() = jsFnComponent()

}
    