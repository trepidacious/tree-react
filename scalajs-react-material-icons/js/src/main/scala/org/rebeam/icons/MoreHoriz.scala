
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MoreHoriz {

  @JSImport("@material-ui/icons/MoreHoriz", JSImport.Default)
  @js.native
  object MoreHorizJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MoreHorizJS)
  
  def apply() = jsFnComponent()

}
    