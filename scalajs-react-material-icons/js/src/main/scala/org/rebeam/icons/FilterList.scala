
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FilterList {

  @JSImport("@material-ui/icons/FilterList", JSImport.Default)
  @js.native
  object FilterListJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FilterListJS)
  
  def apply() = jsFnComponent()

}
    