
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Http {

  @JSImport("@material-ui/icons/Http", JSImport.Default)
  @js.native
  object HttpJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HttpJS)
  
  def apply() = jsFnComponent()

}
    