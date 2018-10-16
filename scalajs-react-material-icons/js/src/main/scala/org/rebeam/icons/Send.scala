
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Send {

  @JSImport("@material-ui/icons/Send", JSImport.Default)
  @js.native
  object SendJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SendJS)
  
  def apply() = jsFnComponent()

}
    