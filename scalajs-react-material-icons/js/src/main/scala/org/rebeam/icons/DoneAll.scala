
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DoneAll {

  @JSImport("@material-ui/icons/DoneAll", JSImport.Default)
  @js.native
  object DoneAllJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DoneAllJS)
  
  def apply() = jsFnComponent()

}
    