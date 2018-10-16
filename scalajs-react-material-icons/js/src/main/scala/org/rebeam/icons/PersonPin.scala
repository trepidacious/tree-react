
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PersonPin {

  @JSImport("@material-ui/icons/PersonPin", JSImport.Default)
  @js.native
  object PersonPinJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PersonPinJS)
  
  def apply() = jsFnComponent()

}
    