
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Input {

  @JSImport("@material-ui/icons/Input", JSImport.Default)
  @js.native
  object InputJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](InputJS)
  
  def apply() = jsFnComponent()

}
    