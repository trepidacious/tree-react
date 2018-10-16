
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CloudOff {

  @JSImport("@material-ui/icons/CloudOff", JSImport.Default)
  @js.native
  object CloudOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CloudOffJS)
  
  def apply() = jsFnComponent()

}
    