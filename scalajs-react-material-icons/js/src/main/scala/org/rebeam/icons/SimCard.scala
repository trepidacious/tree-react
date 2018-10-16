
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SimCard {

  @JSImport("@material-ui/icons/SimCard", JSImport.Default)
  @js.native
  object SimCardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SimCardJS)
  
  def apply() = jsFnComponent()

}
    