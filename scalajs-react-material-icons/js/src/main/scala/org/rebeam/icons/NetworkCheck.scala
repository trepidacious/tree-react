
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NetworkCheck {

  @JSImport("@material-ui/icons/NetworkCheck", JSImport.Default)
  @js.native
  object NetworkCheckJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NetworkCheckJS)
  
  def apply() = jsFnComponent()

}
    