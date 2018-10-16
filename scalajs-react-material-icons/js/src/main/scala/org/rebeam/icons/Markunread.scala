
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Markunread {

  @JSImport("@material-ui/icons/Markunread", JSImport.Default)
  @js.native
  object MarkunreadJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MarkunreadJS)
  
  def apply() = jsFnComponent()

}
    