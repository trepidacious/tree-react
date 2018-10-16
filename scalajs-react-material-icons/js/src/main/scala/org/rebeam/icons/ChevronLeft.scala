
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ChevronLeft {

  @JSImport("@material-ui/icons/ChevronLeft", JSImport.Default)
  @js.native
  object ChevronLeftJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ChevronLeftJS)
  
  def apply() = jsFnComponent()

}
    