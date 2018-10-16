
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Nature {

  @JSImport("@material-ui/icons/Nature", JSImport.Default)
  @js.native
  object NatureJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NatureJS)
  
  def apply() = jsFnComponent()

}
    