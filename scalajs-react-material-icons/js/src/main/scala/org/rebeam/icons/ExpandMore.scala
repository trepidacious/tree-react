
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ExpandMore {

  @JSImport("@material-ui/icons/ExpandMore", JSImport.Default)
  @js.native
  object ExpandMoreJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ExpandMoreJS)
  
  def apply() = jsFnComponent()

}
    