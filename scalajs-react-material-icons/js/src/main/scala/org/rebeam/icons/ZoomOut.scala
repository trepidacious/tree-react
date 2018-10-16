
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ZoomOut {

  @JSImport("@material-ui/icons/ZoomOut", JSImport.Default)
  @js.native
  object ZoomOutJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ZoomOutJS)
  
  def apply() = jsFnComponent()

}
    