
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LeakRemove {

  @JSImport("@material-ui/icons/LeakRemove", JSImport.Default)
  @js.native
  object LeakRemoveJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LeakRemoveJS)
  
  def apply() = jsFnComponent()

}
    