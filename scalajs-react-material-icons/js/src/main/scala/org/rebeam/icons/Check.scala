
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Check {

  @JSImport("@material-ui/icons/Check", JSImport.Default)
  @js.native
  object CheckJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CheckJS)
  
  def apply() = jsFnComponent()

}
    