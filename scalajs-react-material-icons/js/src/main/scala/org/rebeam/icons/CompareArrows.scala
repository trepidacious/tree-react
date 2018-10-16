
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CompareArrows {

  @JSImport("@material-ui/icons/CompareArrows", JSImport.Default)
  @js.native
  object CompareArrowsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CompareArrowsJS)
  
  def apply() = jsFnComponent()

}
    