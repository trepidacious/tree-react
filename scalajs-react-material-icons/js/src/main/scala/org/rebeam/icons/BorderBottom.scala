
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BorderBottom {

  @JSImport("@material-ui/icons/BorderBottom", JSImport.Default)
  @js.native
  object BorderBottomJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BorderBottomJS)
  
  def apply() = jsFnComponent()

}
    