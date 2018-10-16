
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Functions {

  @JSImport("@material-ui/icons/Functions", JSImport.Default)
  @js.native
  object FunctionsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FunctionsJS)
  
  def apply() = jsFnComponent()

}
    