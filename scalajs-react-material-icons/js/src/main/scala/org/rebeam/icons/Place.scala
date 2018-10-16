
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Place {

  @JSImport("@material-ui/icons/Place", JSImport.Default)
  @js.native
  object PlaceJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PlaceJS)
  
  def apply() = jsFnComponent()

}
    