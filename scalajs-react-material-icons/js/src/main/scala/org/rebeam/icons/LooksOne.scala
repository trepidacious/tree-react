
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LooksOne {

  @JSImport("@material-ui/icons/LooksOne", JSImport.Default)
  @js.native
  object LooksOneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LooksOneJS)
  
  def apply() = jsFnComponent()

}
    