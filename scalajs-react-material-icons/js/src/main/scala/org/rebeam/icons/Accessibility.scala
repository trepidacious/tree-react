
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Accessibility {

  @JSImport("@material-ui/icons/Accessibility", JSImport.Default)
  @js.native
  object AccessibilityJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AccessibilityJS)
  
  def apply() = jsFnComponent()

}
    