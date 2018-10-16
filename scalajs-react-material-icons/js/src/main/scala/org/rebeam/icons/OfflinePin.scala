
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object OfflinePin {

  @JSImport("@material-ui/icons/OfflinePin", JSImport.Default)
  @js.native
  object OfflinePinJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](OfflinePinJS)
  
  def apply() = jsFnComponent()

}
    