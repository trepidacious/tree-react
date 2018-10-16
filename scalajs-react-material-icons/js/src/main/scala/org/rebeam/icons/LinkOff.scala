
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LinkOff {

  @JSImport("@material-ui/icons/LinkOff", JSImport.Default)
  @js.native
  object LinkOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LinkOffJS)
  
  def apply() = jsFnComponent()

}
    