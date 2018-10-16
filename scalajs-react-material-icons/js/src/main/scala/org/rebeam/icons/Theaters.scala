
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Theaters {

  @JSImport("@material-ui/icons/Theaters", JSImport.Default)
  @js.native
  object TheatersJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TheatersJS)
  
  def apply() = jsFnComponent()

}
    