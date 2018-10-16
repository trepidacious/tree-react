
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Business {

  @JSImport("@material-ui/icons/Business", JSImport.Default)
  @js.native
  object BusinessJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BusinessJS)
  
  def apply() = jsFnComponent()

}
    