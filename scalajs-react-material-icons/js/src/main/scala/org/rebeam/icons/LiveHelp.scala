
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LiveHelp {

  @JSImport("@material-ui/icons/LiveHelp", JSImport.Default)
  @js.native
  object LiveHelpJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LiveHelpJS)
  
  def apply() = jsFnComponent()

}
    