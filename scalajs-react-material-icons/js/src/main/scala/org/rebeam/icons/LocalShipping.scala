
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalShipping {

  @JSImport("@material-ui/icons/LocalShipping", JSImport.Default)
  @js.native
  object LocalShippingJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalShippingJS)
  
  def apply() = jsFnComponent()

}
    