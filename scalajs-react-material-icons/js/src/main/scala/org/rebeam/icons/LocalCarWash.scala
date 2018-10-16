
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalCarWash {

  @JSImport("@material-ui/icons/LocalCarWash", JSImport.Default)
  @js.native
  object LocalCarWashJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalCarWashJS)
  
  def apply() = jsFnComponent()

}
    