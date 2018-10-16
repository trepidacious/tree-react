
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatSize {

  @JSImport("@material-ui/icons/FormatSize", JSImport.Default)
  @js.native
  object FormatSizeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatSizeJS)
  
  def apply() = jsFnComponent()

}
    