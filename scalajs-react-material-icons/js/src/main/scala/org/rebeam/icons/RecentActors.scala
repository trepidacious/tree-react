
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RecentActors {

  @JSImport("@material-ui/icons/RecentActors", JSImport.Default)
  @js.native
  object RecentActorsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RecentActorsJS)
  
  def apply() = jsFnComponent()

}
    