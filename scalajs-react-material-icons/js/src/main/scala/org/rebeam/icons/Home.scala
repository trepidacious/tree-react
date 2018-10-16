
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Home {

  @JSImport("@material-ui/icons/Home", JSImport.Default)
  @js.native
  object HomeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HomeJS)
  
  def apply() = jsFnComponent()

}
    