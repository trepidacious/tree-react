
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ClearAll {

  @JSImport("@material-ui/icons/ClearAll", JSImport.Default)
  @js.native
  object ClearAllJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ClearAllJS)
  
  def apply() = jsFnComponent()

}
    