
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NotInterested {

  @JSImport("@material-ui/icons/NotInterested", JSImport.Default)
  @js.native
  object NotInterestedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NotInterestedJS)
  
  def apply() = jsFnComponent()

}
    