
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FilterNone {

  @JSImport("@material-ui/icons/FilterNone", JSImport.Default)
  @js.native
  object FilterNoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FilterNoneJS)
  
  def apply() = jsFnComponent()

}
    