
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhoneLocked {

  @JSImport("@material-ui/icons/PhoneLocked", JSImport.Default)
  @js.native
  object PhoneLockedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhoneLockedJS)
  
  def apply() = jsFnComponent()

}
    