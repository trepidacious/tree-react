
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Brightness3 {

  @JSImport("@material-ui/icons/Brightness3", JSImport.Default)
  @js.native
  object Brightness3JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Brightness3JS)
  
  def apply() = jsFnComponent()

}
    