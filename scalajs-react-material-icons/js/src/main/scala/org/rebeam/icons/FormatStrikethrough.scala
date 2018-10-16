
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatStrikethrough {

  @JSImport("@material-ui/icons/FormatStrikethrough", JSImport.Default)
  @js.native
  object FormatStrikethroughJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatStrikethroughJS)
  
  def apply() = jsFnComponent()

}
    