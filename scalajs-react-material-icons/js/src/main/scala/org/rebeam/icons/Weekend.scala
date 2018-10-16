
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Weekend {

  @JSImport("@material-ui/icons/Weekend", JSImport.Default)
  @js.native
  object WeekendJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WeekendJS)
  
  def apply() = jsFnComponent()

}
    