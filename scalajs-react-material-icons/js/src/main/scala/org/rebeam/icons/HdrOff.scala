
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HdrOff {

  @JSImport("@material-ui/icons/HdrOff", JSImport.Default)
  @js.native
  object HdrOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HdrOffJS)
  
  def apply() = jsFnComponent()

}
    