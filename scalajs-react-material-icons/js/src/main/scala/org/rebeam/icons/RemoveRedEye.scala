
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RemoveRedEye {

  @JSImport("@material-ui/icons/RemoveRedEye", JSImport.Default)
  @js.native
  object RemoveRedEyeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RemoveRedEyeJS)
  
  def apply() = jsFnComponent()

}
    