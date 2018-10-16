
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewCompact {

  @JSImport("@material-ui/icons/ViewCompact", JSImport.Default)
  @js.native
  object ViewCompactJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewCompactJS)
  
  def apply() = jsFnComponent()

}
    