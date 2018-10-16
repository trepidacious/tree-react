
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SdCard {

  @JSImport("@material-ui/icons/SdCard", JSImport.Default)
  @js.native
  object SdCardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SdCardJS)
  
  def apply() = jsFnComponent()

}
    