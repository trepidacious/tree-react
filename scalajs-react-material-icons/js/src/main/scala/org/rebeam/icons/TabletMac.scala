
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TabletMac {

  @JSImport("@material-ui/icons/TabletMac", JSImport.Default)
  @js.native
  object TabletMacJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TabletMacJS)
  
  def apply() = jsFnComponent()

}
    