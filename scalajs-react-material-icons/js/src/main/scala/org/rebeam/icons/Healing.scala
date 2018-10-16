
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Healing {

  @JSImport("@material-ui/icons/Healing", JSImport.Default)
  @js.native
  object HealingJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HealingJS)
  
  def apply() = jsFnComponent()

}
    