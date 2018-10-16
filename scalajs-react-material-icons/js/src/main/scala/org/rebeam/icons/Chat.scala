
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Chat {

  @JSImport("@material-ui/icons/Chat", JSImport.Default)
  @js.native
  object ChatJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ChatJS)
  
  def apply() = jsFnComponent()

}
    