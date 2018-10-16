
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object UnfoldMore {

  @JSImport("@material-ui/icons/UnfoldMore", JSImport.Default)
  @js.native
  object UnfoldMoreJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](UnfoldMoreJS)
  
  def apply() = jsFnComponent()

}
    