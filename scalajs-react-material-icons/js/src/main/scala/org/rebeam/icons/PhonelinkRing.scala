
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhonelinkRing {

  @JSImport("@material-ui/icons/PhonelinkRing", JSImport.Default)
  @js.native
  object PhonelinkRingJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhonelinkRingJS)
  
  def apply() = jsFnComponent()

}
    