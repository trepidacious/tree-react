
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Palette {

  @JSImport("@material-ui/icons/Palette", JSImport.Default)
  @js.native
  object PaletteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PaletteJS)
  
  def apply() = jsFnComponent()

}
    