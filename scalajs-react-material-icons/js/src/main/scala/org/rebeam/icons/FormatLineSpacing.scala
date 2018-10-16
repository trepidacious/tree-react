
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatLineSpacing {

  @JSImport("@material-ui/icons/FormatLineSpacing", JSImport.Default)
  @js.native
  object FormatLineSpacingJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatLineSpacingJS)
  
  def apply() = jsFnComponent()

}
    