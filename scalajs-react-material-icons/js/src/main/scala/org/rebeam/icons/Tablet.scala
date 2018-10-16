
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Tablet {

  @JSImport("@material-ui/icons/Tablet", JSImport.Default)
  @js.native
  object TabletJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TabletJS)
  
  def apply() = jsFnComponent()

}
    