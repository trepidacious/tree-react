
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BlurOff {

  @JSImport("@material-ui/icons/BlurOff", JSImport.Default)
  @js.native
  object BlurOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BlurOffJS)
  
  def apply() = jsFnComponent()

}
    