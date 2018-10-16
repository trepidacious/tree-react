
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ContactSupport {

  @JSImport("@material-ui/icons/ContactSupport", JSImport.Default)
  @js.native
  object ContactSupportJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ContactSupportJS)
  
  def apply() = jsFnComponent()

}
    