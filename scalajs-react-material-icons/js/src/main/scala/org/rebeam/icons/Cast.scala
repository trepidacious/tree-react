
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Cast {

  @JSImport("@material-ui/icons/Cast", JSImport.Default)
  @js.native
  object CastJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CastJS)
  
  def apply() = jsFnComponent()

}
    