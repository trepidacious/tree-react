
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DeleteOutline {

  @JSImport("@material-ui/icons/DeleteOutline", JSImport.Default)
  @js.native
  object DeleteOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DeleteOutlineJS)
  
  def apply() = jsFnComponent()

}
    