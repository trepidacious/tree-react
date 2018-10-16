
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HeadsetMic {

  @JSImport("@material-ui/icons/HeadsetMic", JSImport.Default)
  @js.native
  object HeadsetMicJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HeadsetMicJS)
  
  def apply() = jsFnComponent()

}
    