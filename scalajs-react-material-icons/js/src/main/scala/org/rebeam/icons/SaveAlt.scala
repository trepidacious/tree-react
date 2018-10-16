
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SaveAlt {

  @JSImport("@material-ui/icons/SaveAlt", JSImport.Default)
  @js.native
  object SaveAltJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SaveAltJS)
  
  def apply() = jsFnComponent()

}
    