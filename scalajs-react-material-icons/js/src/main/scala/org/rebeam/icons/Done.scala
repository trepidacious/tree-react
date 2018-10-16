
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Done {

  @JSImport("@material-ui/icons/Done", JSImport.Default)
  @js.native
  object DoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DoneJS)
  
  def apply() = jsFnComponent()

}
    