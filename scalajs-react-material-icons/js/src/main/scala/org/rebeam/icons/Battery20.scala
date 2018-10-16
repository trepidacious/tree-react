
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Battery20 {

  @JSImport("@material-ui/icons/Battery20", JSImport.Default)
  @js.native
  object Battery20JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Battery20JS)
  
  def apply() = jsFnComponent()

}
    