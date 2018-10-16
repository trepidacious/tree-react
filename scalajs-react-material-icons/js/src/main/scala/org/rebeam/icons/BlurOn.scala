
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BlurOn {

  @JSImport("@material-ui/icons/BlurOn", JSImport.Default)
  @js.native
  object BlurOnJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BlurOnJS)
  
  def apply() = jsFnComponent()

}
    