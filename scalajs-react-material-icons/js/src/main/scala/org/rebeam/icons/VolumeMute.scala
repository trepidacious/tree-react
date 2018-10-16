
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VolumeMute {

  @JSImport("@material-ui/icons/VolumeMute", JSImport.Default)
  @js.native
  object VolumeMuteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VolumeMuteJS)
  
  def apply() = jsFnComponent()

}
    