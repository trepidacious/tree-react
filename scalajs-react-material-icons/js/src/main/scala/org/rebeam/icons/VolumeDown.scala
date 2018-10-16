
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VolumeDown {

  @JSImport("@material-ui/icons/VolumeDown", JSImport.Default)
  @js.native
  object VolumeDownJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VolumeDownJS)
  
  def apply() = jsFnComponent()

}
    