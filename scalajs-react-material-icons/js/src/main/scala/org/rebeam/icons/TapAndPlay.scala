
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TapAndPlay {

  @JSImport("@material-ui/icons/TapAndPlay", JSImport.Default)
  @js.native
  object TapAndPlayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TapAndPlayJS)
  
  def apply() = jsFnComponent()

}
    