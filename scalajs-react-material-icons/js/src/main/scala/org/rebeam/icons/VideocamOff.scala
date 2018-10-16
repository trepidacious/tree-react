
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VideocamOff {

  @JSImport("@material-ui/icons/VideocamOff", JSImport.Default)
  @js.native
  object VideocamOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VideocamOffJS)
  
  def apply() = jsFnComponent()

}
    