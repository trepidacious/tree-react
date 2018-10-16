
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Minimize {

  @JSImport("@material-ui/icons/Minimize", JSImport.Default)
  @js.native
  object MinimizeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MinimizeJS)
  
  def apply() = jsFnComponent()

}
    