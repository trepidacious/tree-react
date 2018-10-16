
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TrendingFlat {

  @JSImport("@material-ui/icons/TrendingFlat", JSImport.Default)
  @js.native
  object TrendingFlatJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TrendingFlatJS)
  
  def apply() = jsFnComponent()

}
    