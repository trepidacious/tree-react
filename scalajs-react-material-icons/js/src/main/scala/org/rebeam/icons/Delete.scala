
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Delete {

  @JSImport("@material-ui/icons/Delete", JSImport.Default)
  @js.native
  object DeleteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DeleteJS)
  
  def apply() = jsFnComponent()

}
    