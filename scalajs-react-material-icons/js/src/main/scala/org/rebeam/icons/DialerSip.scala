
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DialerSip {

  @JSImport("@material-ui/icons/DialerSip", JSImport.Default)
  @js.native
  object DialerSipJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DialerSipJS)
  
  def apply() = jsFnComponent()

}
    