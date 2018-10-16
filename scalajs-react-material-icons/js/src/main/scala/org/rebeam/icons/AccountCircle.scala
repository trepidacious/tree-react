
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AccountCircle {

  @JSImport("@material-ui/icons/AccountCircle", JSImport.Default)
  @js.native
  object AccountCircleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AccountCircleJS)
  
  def apply() = jsFnComponent()

}
    