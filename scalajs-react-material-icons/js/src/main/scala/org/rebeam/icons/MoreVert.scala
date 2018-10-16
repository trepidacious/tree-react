
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MoreVert {

  @JSImport("@material-ui/icons/MoreVert", JSImport.Default)
  @js.native
  object MoreVertJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MoreVertJS)
  
  def apply() = jsFnComponent()

}
    