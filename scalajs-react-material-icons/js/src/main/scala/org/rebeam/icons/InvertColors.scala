
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object InvertColors {

  @JSImport("@material-ui/icons/InvertColors", JSImport.Default)
  @js.native
  object InvertColorsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](InvertColorsJS)
  
  def apply() = jsFnComponent()

}
    