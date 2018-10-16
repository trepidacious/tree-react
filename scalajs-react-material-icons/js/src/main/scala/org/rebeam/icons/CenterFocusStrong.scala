
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CenterFocusStrong {

  @JSImport("@material-ui/icons/CenterFocusStrong", JSImport.Default)
  @js.native
  object CenterFocusStrongJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CenterFocusStrongJS)
  
  def apply() = jsFnComponent()

}
    