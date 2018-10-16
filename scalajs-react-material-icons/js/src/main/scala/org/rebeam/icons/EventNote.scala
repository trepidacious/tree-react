
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object EventNote {

  @JSImport("@material-ui/icons/EventNote", JSImport.Default)
  @js.native
  object EventNoteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EventNoteJS)
  
  def apply() = jsFnComponent()

}
    