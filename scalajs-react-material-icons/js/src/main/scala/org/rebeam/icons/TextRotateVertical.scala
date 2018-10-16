
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TextRotateVertical {

  @JSImport("@material-ui/icons/TextRotateVertical", JSImport.Default)
  @js.native
  object TextRotateVerticalJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TextRotateVerticalJS)
  
  def apply() = jsFnComponent()

}
    