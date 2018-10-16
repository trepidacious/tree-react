
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VisibilityOff {

  @JSImport("@material-ui/icons/VisibilityOff", JSImport.Default)
  @js.native
  object VisibilityOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VisibilityOffJS)
  
  def apply() = jsFnComponent()

}
    