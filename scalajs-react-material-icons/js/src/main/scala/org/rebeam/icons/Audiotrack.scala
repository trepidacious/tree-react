
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Audiotrack {

  @JSImport("@material-ui/icons/Audiotrack", JSImport.Default)
  @js.native
  object AudiotrackJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AudiotrackJS)
  
  def apply() = jsFnComponent()

}
    