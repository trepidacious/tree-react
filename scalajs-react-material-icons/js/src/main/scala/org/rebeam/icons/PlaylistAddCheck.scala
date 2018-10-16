
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PlaylistAddCheck {

  @JSImport("@material-ui/icons/PlaylistAddCheck", JSImport.Default)
  @js.native
  object PlaylistAddCheckJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PlaylistAddCheckJS)
  
  def apply() = jsFnComponent()

}
    