
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Power {

  @JSImport("@material-ui/icons/Power", JSImport.Default)
  @js.native
  object PowerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PowerJS)
  
  def apply() = jsFnComponent()

}
    