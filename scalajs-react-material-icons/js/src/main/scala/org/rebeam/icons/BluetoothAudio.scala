
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BluetoothAudio {

  @JSImport("@material-ui/icons/BluetoothAudio", JSImport.Default)
  @js.native
  object BluetoothAudioJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BluetoothAudioJS)
  
  def apply() = jsFnComponent()

}
    