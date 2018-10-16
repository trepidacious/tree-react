
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VerticalAlignTop {

  @JSImport("@material-ui/icons/VerticalAlignTop", JSImport.Default)
  @js.native
  object VerticalAlignTopJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VerticalAlignTopJS)
  
  def apply() = jsFnComponent()

}
    