
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Sync {

  @JSImport("@material-ui/icons/Sync", JSImport.Default)
  @js.native
  object SyncJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SyncJS)
  
  def apply() = jsFnComponent()

}
    