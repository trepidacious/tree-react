
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewArray {

  @JSImport("@material-ui/icons/ViewArray", JSImport.Default)
  @js.native
  object ViewArrayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewArrayJS)
  
  def apply() = jsFnComponent()

}
    