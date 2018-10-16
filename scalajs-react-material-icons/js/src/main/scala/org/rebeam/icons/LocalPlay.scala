
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalPlay {

  @JSImport("@material-ui/icons/LocalPlay", JSImport.Default)
  @js.native
  object LocalPlayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalPlayJS)
  
  def apply() = jsFnComponent()

}
    