
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Star {

  @JSImport("@material-ui/icons/Star", JSImport.Default)
  @js.native
  object StarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StarJS)
  
  def apply() = jsFnComponent()

}
    