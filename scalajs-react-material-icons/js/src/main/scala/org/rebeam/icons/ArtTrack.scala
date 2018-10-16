
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArtTrack {

  @JSImport("@material-ui/icons/ArtTrack", JSImport.Default)
  @js.native
  object ArtTrackJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArtTrackJS)
  
  def apply() = jsFnComponent()

}
    