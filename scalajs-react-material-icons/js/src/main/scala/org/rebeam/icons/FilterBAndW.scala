
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FilterBAndW {

  @JSImport("@material-ui/icons/FilterBAndW", JSImport.Default)
  @js.native
  object FilterBAndWJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FilterBAndWJS)
  
  def apply() = jsFnComponent()

}
    