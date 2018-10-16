
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Headset {

  @JSImport("@material-ui/icons/Headset", JSImport.Default)
  @js.native
  object HeadsetJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HeadsetJS)
  
  def apply() = jsFnComponent()

}
    