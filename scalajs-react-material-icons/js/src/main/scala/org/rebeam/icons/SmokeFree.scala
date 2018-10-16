
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SmokeFree {

  @JSImport("@material-ui/icons/SmokeFree", JSImport.Default)
  @js.native
  object SmokeFreeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SmokeFreeJS)
  
  def apply() = jsFnComponent()

}
    