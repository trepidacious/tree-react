
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SkipNext {

  @JSImport("@material-ui/icons/SkipNext", JSImport.Default)
  @js.native
  object SkipNextJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SkipNextJS)
  
  def apply() = jsFnComponent()

}
    