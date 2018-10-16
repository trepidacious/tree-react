
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Lens {

  @JSImport("@material-ui/icons/Lens", JSImport.Default)
  @js.native
  object LensJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LensJS)
  
  def apply() = jsFnComponent()

}
    