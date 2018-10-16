
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Gesture {

  @JSImport("@material-ui/icons/Gesture", JSImport.Default)
  @js.native
  object GestureJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GestureJS)
  
  def apply() = jsFnComponent()

}
    