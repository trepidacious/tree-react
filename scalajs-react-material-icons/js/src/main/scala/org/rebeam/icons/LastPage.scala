
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LastPage {

  @JSImport("@material-ui/icons/LastPage", JSImport.Default)
  @js.native
  object LastPageJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LastPageJS)
  
  def apply() = jsFnComponent()

}
    