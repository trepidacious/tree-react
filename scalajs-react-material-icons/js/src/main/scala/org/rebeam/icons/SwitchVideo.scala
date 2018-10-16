
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SwitchVideo {

  @JSImport("@material-ui/icons/SwitchVideo", JSImport.Default)
  @js.native
  object SwitchVideoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SwitchVideoJS)
  
  def apply() = jsFnComponent()

}
    