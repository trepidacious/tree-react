
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Straighten {

  @JSImport("@material-ui/icons/Straighten", JSImport.Default)
  @js.native
  object StraightenJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StraightenJS)
  
  def apply() = jsFnComponent()

}
    