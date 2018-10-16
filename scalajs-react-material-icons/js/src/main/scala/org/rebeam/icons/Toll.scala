
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Toll {

  @JSImport("@material-ui/icons/Toll", JSImport.Default)
  @js.native
  object TollJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TollJS)
  
  def apply() = jsFnComponent()

}
    