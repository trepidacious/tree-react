
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Stars {

  @JSImport("@material-ui/icons/Stars", JSImport.Default)
  @js.native
  object StarsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StarsJS)
  
  def apply() = jsFnComponent()

}
    