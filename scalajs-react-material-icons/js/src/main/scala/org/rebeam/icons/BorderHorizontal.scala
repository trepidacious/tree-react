
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BorderHorizontal {

  @JSImport("@material-ui/icons/BorderHorizontal", JSImport.Default)
  @js.native
  object BorderHorizontalJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BorderHorizontalJS)
  
  def apply() = jsFnComponent()

}
    