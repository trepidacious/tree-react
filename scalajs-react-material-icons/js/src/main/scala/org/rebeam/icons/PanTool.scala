
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PanTool {

  @JSImport("@material-ui/icons/PanTool", JSImport.Default)
  @js.native
  object PanToolJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PanToolJS)
  
  def apply() = jsFnComponent()

}
    