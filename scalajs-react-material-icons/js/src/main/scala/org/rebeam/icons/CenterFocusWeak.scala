
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CenterFocusWeak {

  @JSImport("@material-ui/icons/CenterFocusWeak", JSImport.Default)
  @js.native
  object CenterFocusWeakJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CenterFocusWeakJS)
  
  def apply() = jsFnComponent()

}
    