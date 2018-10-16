
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Looks4 {

  @JSImport("@material-ui/icons/Looks4", JSImport.Default)
  @js.native
  object Looks4JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Looks4JS)
  
  def apply() = jsFnComponent()

}
    