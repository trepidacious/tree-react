
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Visibility {

  @JSImport("@material-ui/icons/Visibility", JSImport.Default)
  @js.native
  object VisibilityJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VisibilityJS)
  
  def apply() = jsFnComponent()

}
    