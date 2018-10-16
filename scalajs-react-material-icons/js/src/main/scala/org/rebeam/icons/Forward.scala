
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Forward {

  @JSImport("@material-ui/icons/Forward", JSImport.Default)
  @js.native
  object ForwardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ForwardJS)
  
  def apply() = jsFnComponent()

}
    