
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PermDeviceInformation {

  @JSImport("@material-ui/icons/PermDeviceInformation", JSImport.Default)
  @js.native
  object PermDeviceInformationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PermDeviceInformationJS)
  
  def apply() = jsFnComponent()

}
    