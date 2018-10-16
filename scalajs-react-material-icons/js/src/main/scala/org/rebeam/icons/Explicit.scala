
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Explicit {

  @JSImport("@material-ui/icons/Explicit", JSImport.Default)
  @js.native
  object ExplicitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ExplicitJS)
  
  def apply() = jsFnComponent()

}
    