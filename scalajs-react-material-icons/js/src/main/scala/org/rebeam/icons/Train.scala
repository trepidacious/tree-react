
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Train {

  @JSImport("@material-ui/icons/Train", JSImport.Default)
  @js.native
  object TrainJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TrainJS)
  
  def apply() = jsFnComponent()

}
    