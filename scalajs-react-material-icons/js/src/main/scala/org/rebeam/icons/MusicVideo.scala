
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MusicVideo {

  @JSImport("@material-ui/icons/MusicVideo", JSImport.Default)
  @js.native
  object MusicVideoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MusicVideoJS)
  
  def apply() = jsFnComponent()

}
    