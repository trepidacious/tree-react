
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Unarchive {

  @JSImport("@material-ui/icons/Unarchive", JSImport.Default)
  @js.native
  object UnarchiveJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](UnarchiveJS)
  
  def apply() = jsFnComponent()

}
    