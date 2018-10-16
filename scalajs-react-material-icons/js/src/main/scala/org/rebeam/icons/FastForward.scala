
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FastForward {

  @JSImport("@material-ui/icons/FastForward", JSImport.Default)
  @js.native
  object FastForwardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FastForwardJS)
  
  def apply() = jsFnComponent()

}
    