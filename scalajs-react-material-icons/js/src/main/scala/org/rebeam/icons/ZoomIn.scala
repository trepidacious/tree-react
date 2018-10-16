
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ZoomIn {

  @JSImport("@material-ui/icons/ZoomIn", JSImport.Default)
  @js.native
  object ZoomInJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ZoomInJS)
  
  def apply() = jsFnComponent()

}
    