
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalPhone {

  @JSImport("@material-ui/icons/LocalPhone", JSImport.Default)
  @js.native
  object LocalPhoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalPhoneJS)
  
  def apply() = jsFnComponent()

}
    