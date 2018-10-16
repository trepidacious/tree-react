
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SortByAlpha {

  @JSImport("@material-ui/icons/SortByAlpha", JSImport.Default)
  @js.native
  object SortByAlphaJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SortByAlphaJS)
  
  def apply() = jsFnComponent()

}
    