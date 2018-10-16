
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Battery80 {

  @JSImport("@material-ui/icons/Battery80", JSImport.Default)
  @js.native
  object Battery80JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Battery80JS)
  
  def apply() = jsFnComponent()

}
    