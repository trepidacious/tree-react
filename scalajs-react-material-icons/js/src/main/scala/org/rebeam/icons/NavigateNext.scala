
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NavigateNext {

  @JSImport("@material-ui/icons/NavigateNext", JSImport.Default)
  @js.native
  object NavigateNextJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NavigateNextJS)
  
  def apply() = jsFnComponent()

}
    