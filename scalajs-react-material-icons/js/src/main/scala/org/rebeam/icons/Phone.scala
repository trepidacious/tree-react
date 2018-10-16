
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Phone {

  @JSImport("@material-ui/icons/Phone", JSImport.Default)
  @js.native
  object PhoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhoneJS)
  
  def apply() = jsFnComponent()

}
    