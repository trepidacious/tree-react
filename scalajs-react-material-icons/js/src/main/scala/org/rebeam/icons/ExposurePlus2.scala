
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ExposurePlus2 {

  @JSImport("@material-ui/icons/ExposurePlus2", JSImport.Default)
  @js.native
  object ExposurePlus2JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ExposurePlus2JS)
  
  def apply() = jsFnComponent()

}
    