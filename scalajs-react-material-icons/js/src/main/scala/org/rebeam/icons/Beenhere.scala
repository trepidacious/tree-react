
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Beenhere {

  @JSImport("@material-ui/icons/Beenhere", JSImport.Default)
  @js.native
  object BeenhereJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BeenhereJS)
  
  def apply() = jsFnComponent()

}
    