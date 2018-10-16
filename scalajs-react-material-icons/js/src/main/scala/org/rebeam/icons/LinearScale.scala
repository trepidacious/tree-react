
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LinearScale {

  @JSImport("@material-ui/icons/LinearScale", JSImport.Default)
  @js.native
  object LinearScaleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LinearScaleJS)
  
  def apply() = jsFnComponent()

}
    