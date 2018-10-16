
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Group {

  @JSImport("@material-ui/icons/Group", JSImport.Default)
  @js.native
  object GroupJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GroupJS)
  
  def apply() = jsFnComponent()

}
    