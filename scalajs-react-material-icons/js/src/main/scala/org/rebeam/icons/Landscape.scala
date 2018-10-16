
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Landscape {

  @JSImport("@material-ui/icons/Landscape", JSImport.Default)
  @js.native
  object LandscapeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LandscapeJS)
  
  def apply() = jsFnComponent()

}
    