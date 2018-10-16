
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SystemUpdate {

  @JSImport("@material-ui/icons/SystemUpdate", JSImport.Default)
  @js.native
  object SystemUpdateJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SystemUpdateJS)
  
  def apply() = jsFnComponent()

}
    