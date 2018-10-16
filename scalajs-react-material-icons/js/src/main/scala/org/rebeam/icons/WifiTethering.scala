
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WifiTethering {

  @JSImport("@material-ui/icons/WifiTethering", JSImport.Default)
  @js.native
  object WifiTetheringJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WifiTetheringJS)
  
  def apply() = jsFnComponent()

}
    