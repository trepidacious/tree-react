
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MicNone {

  @JSImport("@material-ui/icons/MicNone", JSImport.Default)
  @js.native
  object MicNoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MicNoneJS)
  
  def apply() = jsFnComponent()

}
    