
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DonutLarge {

  @JSImport("@material-ui/icons/DonutLarge", JSImport.Default)
  @js.native
  object DonutLargeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DonutLargeJS)
  
  def apply() = jsFnComponent()

}
    