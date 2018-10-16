
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddAlert {

  @JSImport("@material-ui/icons/AddAlert", JSImport.Default)
  @js.native
  object AddAlertJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddAlertJS)
  
  def apply() = jsFnComponent()

}
    