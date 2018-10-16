
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VolumeOff {

  @JSImport("@material-ui/icons/VolumeOff", JSImport.Default)
  @js.native
  object VolumeOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VolumeOffJS)
  
  def apply() = jsFnComponent()

}
    