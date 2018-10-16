
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BorderTop {

  @JSImport("@material-ui/icons/BorderTop", JSImport.Default)
  @js.native
  object BorderTopJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BorderTopJS)
  
  def apply() = jsFnComponent()

}
    