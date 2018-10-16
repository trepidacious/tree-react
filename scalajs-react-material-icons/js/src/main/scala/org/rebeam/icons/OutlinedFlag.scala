
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object OutlinedFlag {

  @JSImport("@material-ui/icons/OutlinedFlag", JSImport.Default)
  @js.native
  object OutlinedFlagJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](OutlinedFlagJS)
  
  def apply() = jsFnComponent()

}
    