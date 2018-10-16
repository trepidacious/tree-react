
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FilterCenterFocus {

  @JSImport("@material-ui/icons/FilterCenterFocus", JSImport.Default)
  @js.native
  object FilterCenterFocusJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FilterCenterFocusJS)
  
  def apply() = jsFnComponent()

}
    