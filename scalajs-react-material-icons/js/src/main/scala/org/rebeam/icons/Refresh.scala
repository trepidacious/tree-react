
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Refresh {

  @JSImport("@material-ui/icons/Refresh", JSImport.Default)
  @js.native
  object RefreshJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RefreshJS)
  
  def apply() = jsFnComponent()

}
    