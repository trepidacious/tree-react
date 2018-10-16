
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Dialpad {

  @JSImport("@material-ui/icons/Dialpad", JSImport.Default)
  @js.native
  object DialpadJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DialpadJS)
  
  def apply() = jsFnComponent()

}
    