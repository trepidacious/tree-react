
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SyncDisabled {

  @JSImport("@material-ui/icons/SyncDisabled", JSImport.Default)
  @js.native
  object SyncDisabledJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SyncDisabledJS)
  
  def apply() = jsFnComponent()

}
    