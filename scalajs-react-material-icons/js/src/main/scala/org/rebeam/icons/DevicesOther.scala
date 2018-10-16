
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DevicesOther {

  @JSImport("@material-ui/icons/DevicesOther", JSImport.Default)
  @js.native
  object DevicesOtherJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DevicesOtherJS)
  
  def apply() = jsFnComponent()

}
    