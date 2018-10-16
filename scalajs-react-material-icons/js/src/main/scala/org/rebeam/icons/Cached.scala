
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Cached {

  @JSImport("@material-ui/icons/Cached", JSImport.Default)
  @js.native
  object CachedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CachedJS)
  
  def apply() = jsFnComponent()

}
    