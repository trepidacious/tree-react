
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ErrorOutline {

  @JSImport("@material-ui/icons/ErrorOutline", JSImport.Default)
  @js.native
  object ErrorOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ErrorOutlineJS)
  
  def apply() = jsFnComponent()

}
    