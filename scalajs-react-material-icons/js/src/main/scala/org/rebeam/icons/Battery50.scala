
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Battery50 {

  @JSImport("@material-ui/icons/Battery50", JSImport.Default)
  @js.native
  object Battery50JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Battery50JS)
  
  def apply() = jsFnComponent()

}
    