
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MonetizationOn {

  @JSImport("@material-ui/icons/MonetizationOn", JSImport.Default)
  @js.native
  object MonetizationOnJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MonetizationOnJS)
  
  def apply() = jsFnComponent()

}
    