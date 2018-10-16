
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WbSunny {

  @JSImport("@material-ui/icons/WbSunny", JSImport.Default)
  @js.native
  object WbSunnyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WbSunnyJS)
  
  def apply() = jsFnComponent()

}
    