
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Filter9Plus {

  @JSImport("@material-ui/icons/Filter9Plus", JSImport.Default)
  @js.native
  object Filter9PlusJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Filter9PlusJS)
  
  def apply() = jsFnComponent()

}
    