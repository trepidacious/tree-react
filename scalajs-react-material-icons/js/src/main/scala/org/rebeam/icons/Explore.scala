
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Explore {

  @JSImport("@material-ui/icons/Explore", JSImport.Default)
  @js.native
  object ExploreJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ExploreJS)
  
  def apply() = jsFnComponent()

}
    