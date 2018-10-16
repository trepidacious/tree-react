
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NoteAdd {

  @JSImport("@material-ui/icons/NoteAdd", JSImport.Default)
  @js.native
  object NoteAddJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NoteAddJS)
  
  def apply() = jsFnComponent()

}
    