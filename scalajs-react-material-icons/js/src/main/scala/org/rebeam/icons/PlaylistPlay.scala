
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PlaylistPlay {

  @JSImport("@material-ui/icons/PlaylistPlay", JSImport.Default)
  @js.native
  object PlaylistPlayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PlaylistPlayJS)
  
  def apply() = jsFnComponent()

}
    