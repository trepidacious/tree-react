
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FilterVintage {

  @JSImport("@material-ui/icons/FilterVintage", JSImport.Default)
  @js.native
  object FilterVintageJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FilterVintageJS)
  
  def apply() = jsFnComponent()

}
    