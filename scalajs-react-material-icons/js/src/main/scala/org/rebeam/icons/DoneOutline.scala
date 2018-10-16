
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DoneOutline {

  @JSImport("@material-ui/icons/DoneOutline", JSImport.Default)
  @js.native
  object DoneOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DoneOutlineJS)
  
  def apply() = jsFnComponent()

}
    