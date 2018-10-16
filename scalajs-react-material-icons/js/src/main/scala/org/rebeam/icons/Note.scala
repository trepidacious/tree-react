
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Note {

  @JSImport("@material-ui/icons/Note", JSImport.Default)
  @js.native
  object NoteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NoteJS)
  
  def apply() = jsFnComponent()

}
    