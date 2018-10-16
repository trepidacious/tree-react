
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DriveEta {

  @JSImport("@material-ui/icons/DriveEta", JSImport.Default)
  @js.native
  object DriveEtaJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DriveEtaJS)
  
  def apply() = jsFnComponent()

}
    