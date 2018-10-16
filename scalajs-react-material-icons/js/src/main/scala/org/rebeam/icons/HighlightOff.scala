
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HighlightOff {

  @JSImport("@material-ui/icons/HighlightOff", JSImport.Default)
  @js.native
  object HighlightOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HighlightOffJS)
  
  def apply() = jsFnComponent()

}
    