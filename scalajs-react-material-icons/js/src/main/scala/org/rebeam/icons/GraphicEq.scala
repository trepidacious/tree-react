
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object GraphicEq {

  @JSImport("@material-ui/icons/GraphicEq", JSImport.Default)
  @js.native
  object GraphicEqJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GraphicEqJS)
  
  def apply() = jsFnComponent()

}
    