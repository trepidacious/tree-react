
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ExposurePlus1 {

  @JSImport("@material-ui/icons/ExposurePlus1", JSImport.Default)
  @js.native
  object ExposurePlus1JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ExposurePlus1JS)
  
  def apply() = jsFnComponent()

}
    