
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhoneBluetoothSpeaker {

  @JSImport("@material-ui/icons/PhoneBluetoothSpeaker", JSImport.Default)
  @js.native
  object PhoneBluetoothSpeakerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhoneBluetoothSpeakerJS)
  
  def apply() = jsFnComponent()

}
    