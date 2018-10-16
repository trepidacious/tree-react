
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Timeline {

  @JSImport("@material-ui/icons/Timeline", JSImport.Default)
  @js.native
  object TimelineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TimelineJS)
  
  def apply() = jsFnComponent()

}
    