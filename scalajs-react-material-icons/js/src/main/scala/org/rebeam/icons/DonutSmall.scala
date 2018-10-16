
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DonutSmall {

  @JSImport("@material-ui/icons/DonutSmall", JSImport.Default)
  @js.native
  object DonutSmallJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DonutSmallJS)
  
  def apply() = jsFnComponent()

}
    