
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Remove {

  @JSImport("@material-ui/icons/Remove", JSImport.Default)
  @js.native
  object RemoveJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RemoveJS)
  
  def apply() = jsFnComponent()

}
    