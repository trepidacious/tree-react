
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ShortText {

  @JSImport("@material-ui/icons/ShortText", JSImport.Default)
  @js.native
  object ShortTextJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ShortTextJS)
  
  def apply() = jsFnComponent()

}
    