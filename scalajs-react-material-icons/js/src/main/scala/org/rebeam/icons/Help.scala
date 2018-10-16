
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Help {

  @JSImport("@material-ui/icons/Help", JSImport.Default)
  @js.native
  object HelpJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HelpJS)
  
  def apply() = jsFnComponent()

}
    