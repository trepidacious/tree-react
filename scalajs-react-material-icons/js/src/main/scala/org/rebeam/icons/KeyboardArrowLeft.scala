
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object KeyboardArrowLeft {

  @JSImport("@material-ui/icons/KeyboardArrowLeft", JSImport.Default)
  @js.native
  object KeyboardArrowLeftJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](KeyboardArrowLeftJS)
  
  def apply() = jsFnComponent()

}
    