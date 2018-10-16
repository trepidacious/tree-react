
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NetworkLocked {

  @JSImport("@material-ui/icons/NetworkLocked", JSImport.Default)
  @js.native
  object NetworkLockedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NetworkLockedJS)
  
  def apply() = jsFnComponent()

}
    