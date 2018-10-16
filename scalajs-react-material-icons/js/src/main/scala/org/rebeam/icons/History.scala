
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object History {

  @JSImport("@material-ui/icons/History", JSImport.Default)
  @js.native
  object HistoryJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HistoryJS)
  
  def apply() = jsFnComponent()

}
    