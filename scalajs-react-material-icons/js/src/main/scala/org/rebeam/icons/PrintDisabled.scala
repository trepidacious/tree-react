
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PrintDisabled {

  @JSImport("@material-ui/icons/PrintDisabled", JSImport.Default)
  @js.native
  object PrintDisabledJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PrintDisabledJS)
  
  def apply() = jsFnComponent()

}
    