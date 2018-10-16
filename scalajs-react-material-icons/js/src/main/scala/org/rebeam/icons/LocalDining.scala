
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalDining {

  @JSImport("@material-ui/icons/LocalDining", JSImport.Default)
  @js.native
  object LocalDiningJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalDiningJS)
  
  def apply() = jsFnComponent()

}
    