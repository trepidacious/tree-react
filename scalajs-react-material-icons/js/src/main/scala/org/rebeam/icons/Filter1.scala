
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Filter1 {

  @JSImport("@material-ui/icons/Filter1", JSImport.Default)
  @js.native
  object Filter1JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Filter1JS)
  
  def apply() = jsFnComponent()

}
    