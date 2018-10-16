
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AccessTime {

  @JSImport("@material-ui/icons/AccessTime", JSImport.Default)
  @js.native
  object AccessTimeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AccessTimeJS)
  
  def apply() = jsFnComponent()

}
    