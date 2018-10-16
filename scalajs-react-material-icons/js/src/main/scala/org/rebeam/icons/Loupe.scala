
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Loupe {

  @JSImport("@material-ui/icons/Loupe", JSImport.Default)
  @js.native
  object LoupeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LoupeJS)
  
  def apply() = jsFnComponent()

}
    