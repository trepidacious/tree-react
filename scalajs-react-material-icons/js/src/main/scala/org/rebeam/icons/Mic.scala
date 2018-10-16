
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Mic {

  @JSImport("@material-ui/icons/Mic", JSImport.Default)
  @js.native
  object MicJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MicJS)
  
  def apply() = jsFnComponent()

}
    