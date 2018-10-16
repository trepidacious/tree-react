
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Timer3 {

  @JSImport("@material-ui/icons/Timer3", JSImport.Default)
  @js.native
  object Timer3JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Timer3JS)
  
  def apply() = jsFnComponent()

}
    