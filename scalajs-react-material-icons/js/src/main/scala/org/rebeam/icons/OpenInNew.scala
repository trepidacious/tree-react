
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object OpenInNew {

  @JSImport("@material-ui/icons/OpenInNew", JSImport.Default)
  @js.native
  object OpenInNewJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](OpenInNewJS)
  
  def apply() = jsFnComponent()

}
    