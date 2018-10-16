
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FastRewind {

  @JSImport("@material-ui/icons/FastRewind", JSImport.Default)
  @js.native
  object FastRewindJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FastRewindJS)
  
  def apply() = jsFnComponent()

}
    