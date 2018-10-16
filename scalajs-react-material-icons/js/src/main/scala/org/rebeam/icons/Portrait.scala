
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Portrait {

  @JSImport("@material-ui/icons/Portrait", JSImport.Default)
  @js.native
  object PortraitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PortraitJS)
  
  def apply() = jsFnComponent()

}
    