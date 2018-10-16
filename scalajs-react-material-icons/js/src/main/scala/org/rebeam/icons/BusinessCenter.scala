
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BusinessCenter {

  @JSImport("@material-ui/icons/BusinessCenter", JSImport.Default)
  @js.native
  object BusinessCenterJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BusinessCenterJS)
  
  def apply() = jsFnComponent()

}
    