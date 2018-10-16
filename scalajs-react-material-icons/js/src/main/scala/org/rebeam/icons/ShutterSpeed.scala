
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ShutterSpeed {

  @JSImport("@material-ui/icons/ShutterSpeed", JSImport.Default)
  @js.native
  object ShutterSpeedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ShutterSpeedJS)
  
  def apply() = jsFnComponent()

}
    