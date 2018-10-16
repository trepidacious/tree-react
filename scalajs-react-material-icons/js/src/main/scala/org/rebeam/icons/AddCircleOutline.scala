
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddCircleOutline {

  @JSImport("@material-ui/icons/AddCircleOutline", JSImport.Default)
  @js.native
  object AddCircleOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddCircleOutlineJS)
  
  def apply() = jsFnComponent()

}
    