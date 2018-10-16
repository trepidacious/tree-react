
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BorderVertical {

  @JSImport("@material-ui/icons/BorderVertical", JSImport.Default)
  @js.native
  object BorderVerticalJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BorderVerticalJS)
  
  def apply() = jsFnComponent()

}
    