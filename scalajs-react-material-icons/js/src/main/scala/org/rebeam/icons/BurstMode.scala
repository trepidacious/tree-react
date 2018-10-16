
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BurstMode {

  @JSImport("@material-ui/icons/BurstMode", JSImport.Default)
  @js.native
  object BurstModeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BurstModeJS)
  
  def apply() = jsFnComponent()

}
    