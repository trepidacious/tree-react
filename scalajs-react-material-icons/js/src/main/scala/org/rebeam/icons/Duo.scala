
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Duo {

  @JSImport("@material-ui/icons/Duo", JSImport.Default)
  @js.native
  object DuoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DuoJS)
  
  def apply() = jsFnComponent()

}
    