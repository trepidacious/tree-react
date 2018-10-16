
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DeveloperMode {

  @JSImport("@material-ui/icons/DeveloperMode", JSImport.Default)
  @js.native
  object DeveloperModeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DeveloperModeJS)
  
  def apply() = jsFnComponent()

}
    