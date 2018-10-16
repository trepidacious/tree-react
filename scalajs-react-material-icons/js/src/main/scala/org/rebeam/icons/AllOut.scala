
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AllOut {

  @JSImport("@material-ui/icons/AllOut", JSImport.Default)
  @js.native
  object AllOutJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AllOutJS)
  
  def apply() = jsFnComponent()

}
    