
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Highlight {

  @JSImport("@material-ui/icons/Highlight", JSImport.Default)
  @js.native
  object HighlightJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HighlightJS)
  
  def apply() = jsFnComponent()

}
    