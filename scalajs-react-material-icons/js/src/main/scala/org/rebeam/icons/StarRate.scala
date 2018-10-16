
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object StarRate {

  @JSImport("@material-ui/icons/StarRate", JSImport.Default)
  @js.native
  object StarRateJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StarRateJS)
  
  def apply() = jsFnComponent()

}
    