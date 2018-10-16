
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ZoomOutMap {

  @JSImport("@material-ui/icons/ZoomOutMap", JSImport.Default)
  @js.native
  object ZoomOutMapJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ZoomOutMapJS)
  
  def apply() = jsFnComponent()

}
    