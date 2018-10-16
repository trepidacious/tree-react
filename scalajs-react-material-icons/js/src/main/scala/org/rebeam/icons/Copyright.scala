
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Copyright {

  @JSImport("@material-ui/icons/Copyright", JSImport.Default)
  @js.native
  object CopyrightJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CopyrightJS)
  
  def apply() = jsFnComponent()

}
    