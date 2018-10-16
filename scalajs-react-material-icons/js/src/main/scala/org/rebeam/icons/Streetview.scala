
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Streetview {

  @JSImport("@material-ui/icons/Streetview", JSImport.Default)
  @js.native
  object StreetviewJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StreetviewJS)
  
  def apply() = jsFnComponent()

}
    