
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Message {

  @JSImport("@material-ui/icons/Message", JSImport.Default)
  @js.native
  object MessageJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MessageJS)
  
  def apply() = jsFnComponent()

}
    