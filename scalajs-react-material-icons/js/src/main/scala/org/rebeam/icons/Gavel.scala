
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Gavel {

  @JSImport("@material-ui/icons/Gavel", JSImport.Default)
  @js.native
  object GavelJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GavelJS)
  
  def apply() = jsFnComponent()

}
    