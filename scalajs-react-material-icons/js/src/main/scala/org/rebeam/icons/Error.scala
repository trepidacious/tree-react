
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Error {

  @JSImport("@material-ui/icons/Error", JSImport.Default)
  @js.native
  object ErrorJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ErrorJS)
  
  def apply() = jsFnComponent()

}
    