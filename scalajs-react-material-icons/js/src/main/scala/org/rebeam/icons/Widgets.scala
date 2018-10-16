
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Widgets {

  @JSImport("@material-ui/icons/Widgets", JSImport.Default)
  @js.native
  object WidgetsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WidgetsJS)
  
  def apply() = jsFnComponent()

}
    