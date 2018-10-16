
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VolumeUp {

  @JSImport("@material-ui/icons/VolumeUp", JSImport.Default)
  @js.native
  object VolumeUpJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VolumeUpJS)
  
  def apply() = jsFnComponent()

}
    