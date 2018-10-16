
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewList {

  @JSImport("@material-ui/icons/ViewList", JSImport.Default)
  @js.native
  object ViewListJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewListJS)
  
  def apply() = jsFnComponent()

}
    