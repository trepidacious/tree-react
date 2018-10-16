
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WifiOff {

  @JSImport("@material-ui/icons/WifiOff", JSImport.Default)
  @js.native
  object WifiOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WifiOffJS)
  
  def apply() = jsFnComponent()

}
    