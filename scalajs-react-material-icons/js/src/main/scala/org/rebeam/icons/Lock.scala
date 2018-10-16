
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Lock {

  @JSImport("@material-ui/icons/Lock", JSImport.Default)
  @js.native
  object LockJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LockJS)
  
  def apply() = jsFnComponent()

}
    