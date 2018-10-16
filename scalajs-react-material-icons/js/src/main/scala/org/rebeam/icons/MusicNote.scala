
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MusicNote {

  @JSImport("@material-ui/icons/MusicNote", JSImport.Default)
  @js.native
  object MusicNoteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MusicNoteJS)
  
  def apply() = jsFnComponent()

}
    