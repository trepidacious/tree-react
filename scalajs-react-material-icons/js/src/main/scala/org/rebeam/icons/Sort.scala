
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Sort {

  @JSImport("@material-ui/icons/Sort", JSImport.Default)
  @js.native
  object SortJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SortJS)
  
  def apply() = jsFnComponent()

}
    