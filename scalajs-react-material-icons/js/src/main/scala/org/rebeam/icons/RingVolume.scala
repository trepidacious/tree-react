
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RingVolume {

  @JSImport("@material-ui/icons/RingVolume", JSImport.Default)
  @js.native
  object RingVolumeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RingVolumeJS)
  
  def apply() = jsFnComponent()

}
    