
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalMall {

  @JSImport("@material-ui/icons/LocalMall", JSImport.Default)
  @js.native
  object LocalMallJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalMallJS)
  
  def apply() = jsFnComponent()

}
    