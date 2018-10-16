
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VerticalAlignBottom {

  @JSImport("@material-ui/icons/VerticalAlignBottom", JSImport.Default)
  @js.native
  object VerticalAlignBottomJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VerticalAlignBottomJS)
  
  def apply() = jsFnComponent()

}
    