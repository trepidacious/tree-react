
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Rowing {

  @JSImport("@material-ui/icons/Rowing", JSImport.Default)
  @js.native
  object RowingJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RowingJS)
  
  def apply() = jsFnComponent()

}
    