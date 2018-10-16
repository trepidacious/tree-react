
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WatchLater {

  @JSImport("@material-ui/icons/WatchLater", JSImport.Default)
  @js.native
  object WatchLaterJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WatchLaterJS)
  
  def apply() = jsFnComponent()

}
    