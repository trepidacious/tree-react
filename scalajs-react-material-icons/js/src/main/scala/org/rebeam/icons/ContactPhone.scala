
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ContactPhone {

  @JSImport("@material-ui/icons/ContactPhone", JSImport.Default)
  @js.native
  object ContactPhoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ContactPhoneJS)
  
  def apply() = jsFnComponent()

}
    