
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TrendingUp {

  @JSImport("@material-ui/icons/TrendingUp", JSImport.Default)
  @js.native
  object TrendingUpJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TrendingUpJS)
  
  def apply() = jsFnComponent()

}
    