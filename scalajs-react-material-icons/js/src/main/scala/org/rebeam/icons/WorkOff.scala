
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WorkOff {

  @JSImport("@material-ui/icons/WorkOff", JSImport.Default)
  @js.native
  object WorkOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WorkOffJS)
  
  def apply() = jsFnComponent()

}
    