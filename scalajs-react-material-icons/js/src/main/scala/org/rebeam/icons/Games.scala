
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Games {

  @JSImport("@material-ui/icons/Games", JSImport.Default)
  @js.native
  object GamesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GamesJS)
  
  def apply() = jsFnComponent()

}
    