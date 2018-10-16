
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CheckCircleOutline {

  @JSImport("@material-ui/icons/CheckCircleOutline", JSImport.Default)
  @js.native
  object CheckCircleOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CheckCircleOutlineJS)
  
  def apply() = jsFnComponent()

}
    