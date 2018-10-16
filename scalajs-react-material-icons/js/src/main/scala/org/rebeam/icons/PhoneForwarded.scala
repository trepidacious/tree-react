
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhoneForwarded {

  @JSImport("@material-ui/icons/PhoneForwarded", JSImport.Default)
  @js.native
  object PhoneForwardedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhoneForwardedJS)
  
  def apply() = jsFnComponent()

}
    