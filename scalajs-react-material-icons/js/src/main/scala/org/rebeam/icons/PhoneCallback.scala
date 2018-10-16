
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhoneCallback {

  @JSImport("@material-ui/icons/PhoneCallback", JSImport.Default)
  @js.native
  object PhoneCallbackJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhoneCallbackJS)
  
  def apply() = jsFnComponent()

}
    