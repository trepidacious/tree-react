
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CloudDone {

  @JSImport("@material-ui/icons/CloudDone", JSImport.Default)
  @js.native
  object CloudDoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CloudDoneJS)
  
  def apply() = jsFnComponent()

}
    