
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalCafe {

  @JSImport("@material-ui/icons/LocalCafe", JSImport.Default)
  @js.native
  object LocalCafeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalCafeJS)
  
  def apply() = jsFnComponent()

}
    