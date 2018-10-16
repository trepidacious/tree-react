
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Launch {

  @JSImport("@material-ui/icons/Launch", JSImport.Default)
  @js.native
  object LaunchJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LaunchJS)
  
  def apply() = jsFnComponent()

}
    