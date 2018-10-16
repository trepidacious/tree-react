
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object InvertColorsOff {

  @JSImport("@material-ui/icons/InvertColorsOff", JSImport.Default)
  @js.native
  object InvertColorsOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](InvertColorsOffJS)
  
  def apply() = jsFnComponent()

}
    