
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Hd {

  @JSImport("@material-ui/icons/Hd", JSImport.Default)
  @js.native
  object HdJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HdJS)
  
  def apply() = jsFnComponent()

}
    