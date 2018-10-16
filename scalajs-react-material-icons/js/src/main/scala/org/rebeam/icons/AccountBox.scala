
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AccountBox {

  @JSImport("@material-ui/icons/AccountBox", JSImport.Default)
  @js.native
  object AccountBoxJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AccountBoxJS)
  
  def apply() = jsFnComponent()

}
    