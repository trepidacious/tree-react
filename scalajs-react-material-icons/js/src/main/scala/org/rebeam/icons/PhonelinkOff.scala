
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhonelinkOff {

  @JSImport("@material-ui/icons/PhonelinkOff", JSImport.Default)
  @js.native
  object PhonelinkOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhonelinkOffJS)
  
  def apply() = jsFnComponent()

}
    