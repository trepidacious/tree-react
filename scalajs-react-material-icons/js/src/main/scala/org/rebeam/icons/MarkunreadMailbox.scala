
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MarkunreadMailbox {

  @JSImport("@material-ui/icons/MarkunreadMailbox", JSImport.Default)
  @js.native
  object MarkunreadMailboxJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MarkunreadMailboxJS)
  
  def apply() = jsFnComponent()

}
    