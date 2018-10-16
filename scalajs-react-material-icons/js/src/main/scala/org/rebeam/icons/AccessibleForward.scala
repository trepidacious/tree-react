
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AccessibleForward {

  @JSImport("@material-ui/icons/AccessibleForward", JSImport.Default)
  @js.native
  object AccessibleForwardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AccessibleForwardJS)
  
  def apply() = jsFnComponent()

}
    