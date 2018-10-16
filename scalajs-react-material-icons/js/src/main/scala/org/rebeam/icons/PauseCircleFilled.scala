
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PauseCircleFilled {

  @JSImport("@material-ui/icons/PauseCircleFilled", JSImport.Default)
  @js.native
  object PauseCircleFilledJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PauseCircleFilledJS)
  
  def apply() = jsFnComponent()

}
    