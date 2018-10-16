
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhoneIphone {

  @JSImport("@material-ui/icons/PhoneIphone", JSImport.Default)
  @js.native
  object PhoneIphoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhoneIphoneJS)
  
  def apply() = jsFnComponent()

}
    