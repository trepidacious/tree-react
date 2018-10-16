
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Battery90 {

  @JSImport("@material-ui/icons/Battery90", JSImport.Default)
  @js.native
  object Battery90JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Battery90JS)
  
  def apply() = jsFnComponent()

}
    