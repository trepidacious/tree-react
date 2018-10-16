
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Opacity {

  @JSImport("@material-ui/icons/Opacity", JSImport.Default)
  @js.native
  object OpacityJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](OpacityJS)
  
  def apply() = jsFnComponent()

}
    