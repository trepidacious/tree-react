
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Looks3 {

  @JSImport("@material-ui/icons/Looks3", JSImport.Default)
  @js.native
  object Looks3JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Looks3JS)
  
  def apply() = jsFnComponent()

}
    