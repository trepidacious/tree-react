
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PlusOne {

  @JSImport("@material-ui/icons/PlusOne", JSImport.Default)
  @js.native
  object PlusOneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PlusOneJS)
  
  def apply() = jsFnComponent()

}
    