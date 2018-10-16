
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SupervisorAccount {

  @JSImport("@material-ui/icons/SupervisorAccount", JSImport.Default)
  @js.native
  object SupervisorAccountJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SupervisorAccountJS)
  
  def apply() = jsFnComponent()

}
    