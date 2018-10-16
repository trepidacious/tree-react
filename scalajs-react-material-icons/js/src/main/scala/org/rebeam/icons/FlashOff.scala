
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FlashOff {

  @JSImport("@material-ui/icons/FlashOff", JSImport.Default)
  @js.native
  object FlashOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FlashOffJS)
  
  def apply() = jsFnComponent()

}
    