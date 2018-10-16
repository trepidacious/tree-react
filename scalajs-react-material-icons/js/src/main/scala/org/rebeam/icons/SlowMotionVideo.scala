
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SlowMotionVideo {

  @JSImport("@material-ui/icons/SlowMotionVideo", JSImport.Default)
  @js.native
  object SlowMotionVideoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SlowMotionVideoJS)
  
  def apply() = jsFnComponent()

}
    