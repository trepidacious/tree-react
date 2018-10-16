
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Accessible {

  @JSImport("@material-ui/icons/Accessible", JSImport.Default)
  @js.native
  object AccessibleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AccessibleJS)
  
  def apply() = jsFnComponent()

}
    