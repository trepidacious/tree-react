
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Style {

  @JSImport("@material-ui/icons/Style", JSImport.Default)
  @js.native
  object StyleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StyleJS)
  
  def apply() = jsFnComponent()

}
    