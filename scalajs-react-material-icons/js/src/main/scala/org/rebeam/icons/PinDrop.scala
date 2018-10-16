
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PinDrop {

  @JSImport("@material-ui/icons/PinDrop", JSImport.Default)
  @js.native
  object PinDropJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PinDropJS)
  
  def apply() = jsFnComponent()

}
    