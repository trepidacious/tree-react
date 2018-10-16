
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WorkOutline {

  @JSImport("@material-ui/icons/WorkOutline", JSImport.Default)
  @js.native
  object WorkOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WorkOutlineJS)
  
  def apply() = jsFnComponent()

}
    