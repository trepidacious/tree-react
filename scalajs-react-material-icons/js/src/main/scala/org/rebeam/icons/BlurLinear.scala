
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BlurLinear {

  @JSImport("@material-ui/icons/BlurLinear", JSImport.Default)
  @js.native
  object BlurLinearJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BlurLinearJS)
  
  def apply() = jsFnComponent()

}
    