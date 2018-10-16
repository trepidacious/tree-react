
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object StarHalf {

  @JSImport("@material-ui/icons/StarHalf", JSImport.Default)
  @js.native
  object StarHalfJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StarHalfJS)
  
  def apply() = jsFnComponent()

}
    