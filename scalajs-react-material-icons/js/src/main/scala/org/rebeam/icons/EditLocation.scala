
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object EditLocation {

  @JSImport("@material-ui/icons/EditLocation", JSImport.Default)
  @js.native
  object EditLocationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EditLocationJS)
  
  def apply() = jsFnComponent()

}
    