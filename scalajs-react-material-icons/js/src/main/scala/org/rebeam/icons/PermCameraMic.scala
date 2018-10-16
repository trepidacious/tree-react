
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PermCameraMic {

  @JSImport("@material-ui/icons/PermCameraMic", JSImport.Default)
  @js.native
  object PermCameraMicJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PermCameraMicJS)
  
  def apply() = jsFnComponent()

}
    