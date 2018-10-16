
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object OfflineBolt {

  @JSImport("@material-ui/icons/OfflineBolt", JSImport.Default)
  @js.native
  object OfflineBoltJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](OfflineBoltJS)
  
  def apply() = jsFnComponent()

}
    