
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MobileScreenShare {

  @JSImport("@material-ui/icons/MobileScreenShare", JSImport.Default)
  @js.native
  object MobileScreenShareJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MobileScreenShareJS)
  
  def apply() = jsFnComponent()

}
    