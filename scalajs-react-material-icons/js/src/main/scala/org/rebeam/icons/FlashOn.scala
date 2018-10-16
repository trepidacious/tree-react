
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FlashOn {

  @JSImport("@material-ui/icons/FlashOn", JSImport.Default)
  @js.native
  object FlashOnJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FlashOnJS)
  
  def apply() = jsFnComponent()

}
    