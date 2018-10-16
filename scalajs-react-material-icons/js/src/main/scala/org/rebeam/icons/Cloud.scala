
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Cloud {

  @JSImport("@material-ui/icons/Cloud", JSImport.Default)
  @js.native
  object CloudJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CloudJS)
  
  def apply() = jsFnComponent()

}
    