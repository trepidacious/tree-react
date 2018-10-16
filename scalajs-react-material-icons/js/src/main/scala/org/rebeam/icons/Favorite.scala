
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Favorite {

  @JSImport("@material-ui/icons/Favorite", JSImport.Default)
  @js.native
  object FavoriteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FavoriteJS)
  
  def apply() = jsFnComponent()

}
    