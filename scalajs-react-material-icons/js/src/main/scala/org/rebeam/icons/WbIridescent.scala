
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WbIridescent {

  @JSImport("@material-ui/icons/WbIridescent", JSImport.Default)
  @js.native
  object WbIridescentJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WbIridescentJS)
  
  def apply() = jsFnComponent()

}
    