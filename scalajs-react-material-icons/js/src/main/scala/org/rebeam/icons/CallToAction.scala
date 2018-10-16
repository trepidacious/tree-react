
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CallToAction {

  @JSImport("@material-ui/icons/CallToAction", JSImport.Default)
  @js.native
  object CallToActionJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CallToActionJS)
  
  def apply() = jsFnComponent()

}
    