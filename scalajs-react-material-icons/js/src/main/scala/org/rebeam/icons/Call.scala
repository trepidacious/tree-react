
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Call {

  @JSImport("@material-ui/icons/Call", JSImport.Default)
  @js.native
  object CallJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CallJS)
  
  def apply() = jsFnComponent()

}
    