
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Map {

  @JSImport("@material-ui/icons/Map", JSImport.Default)
  @js.native
  object MapJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MapJS)
  
  def apply() = jsFnComponent()

}
    