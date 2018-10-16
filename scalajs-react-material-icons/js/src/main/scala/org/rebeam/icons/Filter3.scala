
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Filter3 {

  @JSImport("@material-ui/icons/Filter3", JSImport.Default)
  @js.native
  object Filter3JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Filter3JS)
  
  def apply() = jsFnComponent()

}
    