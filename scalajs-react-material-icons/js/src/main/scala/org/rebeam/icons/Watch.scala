
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Watch {

  @JSImport("@material-ui/icons/Watch", JSImport.Default)
  @js.native
  object WatchJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WatchJS)
  
  def apply() = jsFnComponent()

}
    