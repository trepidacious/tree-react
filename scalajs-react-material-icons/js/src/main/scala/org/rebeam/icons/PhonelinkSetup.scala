
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhonelinkSetup {

  @JSImport("@material-ui/icons/PhonelinkSetup", JSImport.Default)
  @js.native
  object PhonelinkSetupJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhonelinkSetupJS)
  
  def apply() = jsFnComponent()

}
    