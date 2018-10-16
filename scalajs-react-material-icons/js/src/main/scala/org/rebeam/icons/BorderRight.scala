
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BorderRight {

  @JSImport("@material-ui/icons/BorderRight", JSImport.Default)
  @js.native
  object BorderRightJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BorderRightJS)
  
  def apply() = jsFnComponent()

}
    