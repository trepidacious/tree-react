
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Filter {

  @JSImport("@material-ui/icons/Filter", JSImport.Default)
  @js.native
  object FilterJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FilterJS)
  
  def apply() = jsFnComponent()

}
    