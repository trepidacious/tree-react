
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ChromeReaderMode {

  @JSImport("@material-ui/icons/ChromeReaderMode", JSImport.Default)
  @js.native
  object ChromeReaderModeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ChromeReaderModeJS)
  
  def apply() = jsFnComponent()

}
    