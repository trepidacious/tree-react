
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PregnantWoman {

  @JSImport("@material-ui/icons/PregnantWoman", JSImport.Default)
  @js.native
  object PregnantWomanJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PregnantWomanJS)
  
  def apply() = jsFnComponent()

}
    