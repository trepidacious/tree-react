
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FavoriteBorder {

  @JSImport("@material-ui/icons/FavoriteBorder", JSImport.Default)
  @js.native
  object FavoriteBorderJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FavoriteBorderJS)
  
  def apply() = jsFnComponent()

}
    