
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Tram {

  @JSImport("@material-ui/icons/Tram", JSImport.Default)
  @js.native
  object TramJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TramJS)
  
  def apply() = jsFnComponent()

}
    