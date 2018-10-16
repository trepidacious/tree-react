
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PermPhoneMsg {

  @JSImport("@material-ui/icons/PermPhoneMsg", JSImport.Default)
  @js.native
  object PermPhoneMsgJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PermPhoneMsgJS)
  
  def apply() = jsFnComponent()

}
    