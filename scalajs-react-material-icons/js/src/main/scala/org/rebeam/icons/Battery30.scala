
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Battery30 {

  @JSImport("@material-ui/icons/Battery30", JSImport.Default)
  @js.native
  object Battery30JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Battery30JS)
  
  def apply() = jsFnComponent()

}
    