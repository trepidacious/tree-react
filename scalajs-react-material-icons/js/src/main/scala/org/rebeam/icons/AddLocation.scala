
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddLocation {

  @JSImport("@material-ui/icons/AddLocation", JSImport.Default)
  @js.native
  object AddLocationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddLocationJS)
  
  def apply() = jsFnComponent()

}
    