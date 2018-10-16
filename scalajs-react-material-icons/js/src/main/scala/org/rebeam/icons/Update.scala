
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Update {

  @JSImport("@material-ui/icons/Update", JSImport.Default)
  @js.native
  object UpdateJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](UpdateJS)
  
  def apply() = jsFnComponent()

}
    