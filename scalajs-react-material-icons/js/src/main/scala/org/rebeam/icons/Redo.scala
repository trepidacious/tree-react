
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Redo {

  @JSImport("@material-ui/icons/Redo", JSImport.Default)
  @js.native
  object RedoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RedoJS)
  
  def apply() = jsFnComponent()

}
    