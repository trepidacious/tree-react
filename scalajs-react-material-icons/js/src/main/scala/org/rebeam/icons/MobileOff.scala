
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MobileOff {

  @JSImport("@material-ui/icons/MobileOff", JSImport.Default)
  @js.native
  object MobileOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MobileOffJS)
  
  def apply() = jsFnComponent()

}
    