
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Smartphone {

  @JSImport("@material-ui/icons/Smartphone", JSImport.Default)
  @js.native
  object SmartphoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SmartphoneJS)
  
  def apply() = jsFnComponent()

}
    