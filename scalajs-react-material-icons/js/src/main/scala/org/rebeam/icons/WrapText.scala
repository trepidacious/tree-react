
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WrapText {

  @JSImport("@material-ui/icons/WrapText", JSImport.Default)
  @js.native
  object WrapTextJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WrapTextJS)
  
  def apply() = jsFnComponent()

}
    