
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsInputSvideo {

  @JSImport("@material-ui/icons/SettingsInputSvideo", JSImport.Default)
  @js.native
  object SettingsInputSvideoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsInputSvideoJS)
  
  def apply() = jsFnComponent()

}
    