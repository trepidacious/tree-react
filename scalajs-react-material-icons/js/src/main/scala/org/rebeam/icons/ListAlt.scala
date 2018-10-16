
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ListAlt {

  @JSImport("@material-ui/icons/ListAlt", JSImport.Default)
  @js.native
  object ListAltJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ListAltJS)
  
  def apply() = jsFnComponent()

}
    