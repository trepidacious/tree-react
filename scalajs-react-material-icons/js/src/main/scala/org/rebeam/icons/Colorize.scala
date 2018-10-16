
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Colorize {

  @JSImport("@material-ui/icons/Colorize", JSImport.Default)
  @js.native
  object ColorizeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ColorizeJS)
  
  def apply() = jsFnComponent()

}
    