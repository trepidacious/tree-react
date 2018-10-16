
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Security {

  @JSImport("@material-ui/icons/Security", JSImport.Default)
  @js.native
  object SecurityJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SecurityJS)
  
  def apply() = jsFnComponent()

}
    