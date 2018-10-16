
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DeveloperBoard {

  @JSImport("@material-ui/icons/DeveloperBoard", JSImport.Default)
  @js.native
  object DeveloperBoardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DeveloperBoardJS)
  
  def apply() = jsFnComponent()

}
    