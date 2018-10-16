
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NearMe {

  @JSImport("@material-ui/icons/NearMe", JSImport.Default)
  @js.native
  object NearMeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NearMeJS)
  
  def apply() = jsFnComponent()

}
    