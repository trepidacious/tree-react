
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SkipPrevious {

  @JSImport("@material-ui/icons/SkipPrevious", JSImport.Default)
  @js.native
  object SkipPreviousJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SkipPreviousJS)
  
  def apply() = jsFnComponent()

}
    