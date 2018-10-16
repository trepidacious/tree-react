
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Album {

  @JSImport("@material-ui/icons/Album", JSImport.Default)
  @js.native
  object AlbumJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AlbumJS)
  
  def apply() = jsFnComponent()

}
    