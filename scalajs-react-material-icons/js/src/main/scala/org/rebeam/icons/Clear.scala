
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Clear {

  @JSImport("@material-ui/icons/Clear", JSImport.Default)
  @js.native
  object ClearJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ClearJS)
  
  def apply() = jsFnComponent()

}
    