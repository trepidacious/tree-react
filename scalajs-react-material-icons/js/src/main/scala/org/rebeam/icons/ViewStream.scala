
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewStream {

  @JSImport("@material-ui/icons/ViewStream", JSImport.Default)
  @js.native
  object ViewStreamJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewStreamJS)
  
  def apply() = jsFnComponent()

}
    