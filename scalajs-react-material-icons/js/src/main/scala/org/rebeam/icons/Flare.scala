
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Flare {

  @JSImport("@material-ui/icons/Flare", JSImport.Default)
  @js.native
  object FlareJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FlareJS)
  
  def apply() = jsFnComponent()

}
    