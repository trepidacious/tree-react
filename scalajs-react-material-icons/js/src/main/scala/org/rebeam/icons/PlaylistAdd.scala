
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PlaylistAdd {

  @JSImport("@material-ui/icons/PlaylistAdd", JSImport.Default)
  @js.native
  object PlaylistAddJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PlaylistAddJS)
  
  def apply() = jsFnComponent()

}
    