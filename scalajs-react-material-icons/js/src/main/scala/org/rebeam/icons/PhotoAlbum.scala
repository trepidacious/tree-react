
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhotoAlbum {

  @JSImport("@material-ui/icons/PhotoAlbum", JSImport.Default)
  @js.native
  object PhotoAlbumJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhotoAlbumJS)
  
  def apply() = jsFnComponent()

}
    