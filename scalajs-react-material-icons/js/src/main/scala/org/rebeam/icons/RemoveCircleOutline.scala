
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RemoveCircleOutline {

  @JSImport("@material-ui/icons/RemoveCircleOutline", JSImport.Default)
  @js.native
  object RemoveCircleOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RemoveCircleOutlineJS)
  
  def apply() = jsFnComponent()

}
    