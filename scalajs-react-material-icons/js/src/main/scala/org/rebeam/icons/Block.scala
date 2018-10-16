
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Block {

  @JSImport("@material-ui/icons/Block", JSImport.Default)
  @js.native
  object BlockJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BlockJS)
  
  def apply() = jsFnComponent()

}
    