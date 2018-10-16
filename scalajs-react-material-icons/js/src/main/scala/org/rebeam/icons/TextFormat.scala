
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TextFormat {

  @JSImport("@material-ui/icons/TextFormat", JSImport.Default)
  @js.native
  object TextFormatJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TextFormatJS)
  
  def apply() = jsFnComponent()

}
    