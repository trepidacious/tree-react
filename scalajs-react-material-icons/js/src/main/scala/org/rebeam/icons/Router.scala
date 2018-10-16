
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Router {

  @JSImport("@material-ui/icons/Router", JSImport.Default)
  @js.native
  object RouterJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RouterJS)
  
  def apply() = jsFnComponent()

}
    