
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LockOpen {

  @JSImport("@material-ui/icons/LockOpen", JSImport.Default)
  @js.native
  object LockOpenJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LockOpenJS)
  
  def apply() = jsFnComponent()

}
    