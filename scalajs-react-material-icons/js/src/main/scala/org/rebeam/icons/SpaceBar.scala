
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SpaceBar {

  @JSImport("@material-ui/icons/SpaceBar", JSImport.Default)
  @js.native
  object SpaceBarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SpaceBarJS)
  
  def apply() = jsFnComponent()

}
    