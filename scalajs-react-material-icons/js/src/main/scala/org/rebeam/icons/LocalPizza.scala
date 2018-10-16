
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalPizza {

  @JSImport("@material-ui/icons/LocalPizza", JSImport.Default)
  @js.native
  object LocalPizzaJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalPizzaJS)
  
  def apply() = jsFnComponent()

}
    