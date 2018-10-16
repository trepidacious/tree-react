
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ExploreOff {

  @JSImport("@material-ui/icons/ExploreOff", JSImport.Default)
  @js.native
  object ExploreOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ExploreOffJS)
  
  def apply() = jsFnComponent()

}
    