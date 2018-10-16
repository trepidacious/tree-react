
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Crop32 {

  @JSImport("@material-ui/icons/Crop32", JSImport.Default)
  @js.native
  object Crop32JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Crop32JS)
  
  def apply() = jsFnComponent()

}
    