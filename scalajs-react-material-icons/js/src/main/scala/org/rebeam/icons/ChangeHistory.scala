
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ChangeHistory {

  @JSImport("@material-ui/icons/ChangeHistory", JSImport.Default)
  @js.native
  object ChangeHistoryJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ChangeHistoryJS)
  
  def apply() = jsFnComponent()

}
    