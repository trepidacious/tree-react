
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PersonAdd {

  @JSImport("@material-ui/icons/PersonAdd", JSImport.Default)
  @js.native
  object PersonAddJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PersonAddJS)
  
  def apply() = jsFnComponent()

}
    