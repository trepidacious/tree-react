
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Replay {

  @JSImport("@material-ui/icons/Replay", JSImport.Default)
  @js.native
  object ReplayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ReplayJS)
  
  def apply() = jsFnComponent()

}
    