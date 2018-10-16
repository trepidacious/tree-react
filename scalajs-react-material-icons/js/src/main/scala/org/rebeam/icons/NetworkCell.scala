
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NetworkCell {

  @JSImport("@material-ui/icons/NetworkCell", JSImport.Default)
  @js.native
  object NetworkCellJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NetworkCellJS)
  
  def apply() = jsFnComponent()

}
    