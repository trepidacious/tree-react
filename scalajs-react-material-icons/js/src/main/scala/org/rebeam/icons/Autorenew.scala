
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Autorenew {

  @JSImport("@material-ui/icons/Autorenew", JSImport.Default)
  @js.native
  object AutorenewJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AutorenewJS)
  
  def apply() = jsFnComponent()

}
    