
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LayersClear {

  @JSImport("@material-ui/icons/LayersClear", JSImport.Default)
  @js.native
  object LayersClearJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LayersClearJS)
  
  def apply() = jsFnComponent()

}
    