
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Notes {

  @JSImport("@material-ui/icons/Notes", JSImport.Default)
  @js.native
  object NotesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NotesJS)
  
  def apply() = jsFnComponent()

}
    