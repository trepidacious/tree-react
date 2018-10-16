
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Restore {

  @JSImport("@material-ui/icons/Restore", JSImport.Default)
  @js.native
  object RestoreJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RestoreJS)
  
  def apply() = jsFnComponent()

}
    