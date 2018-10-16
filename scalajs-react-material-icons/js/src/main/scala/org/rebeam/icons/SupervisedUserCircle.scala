
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SupervisedUserCircle {

  @JSImport("@material-ui/icons/SupervisedUserCircle", JSImport.Default)
  @js.native
  object SupervisedUserCircleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SupervisedUserCircleJS)
  
  def apply() = jsFnComponent()

}
    