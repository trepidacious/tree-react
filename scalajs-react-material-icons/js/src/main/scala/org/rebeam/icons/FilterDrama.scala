
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FilterDrama {

  @JSImport("@material-ui/icons/FilterDrama", JSImport.Default)
  @js.native
  object FilterDramaJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FilterDramaJS)
  
  def apply() = jsFnComponent()

}
    