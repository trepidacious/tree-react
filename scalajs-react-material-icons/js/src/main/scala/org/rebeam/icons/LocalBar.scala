
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalBar {

  @JSImport("@material-ui/icons/LocalBar", JSImport.Default)
  @js.native
  object LocalBarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalBarJS)
  
  def apply() = jsFnComponent()

}
    