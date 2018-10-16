
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Android {

  @JSImport("@material-ui/icons/Android", JSImport.Default)
  @js.native
  object AndroidJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AndroidJS)
  
  def apply() = jsFnComponent()

}
    