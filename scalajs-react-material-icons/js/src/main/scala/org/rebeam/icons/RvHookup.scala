
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RvHookup {

  @JSImport("@material-ui/icons/RvHookup", JSImport.Default)
  @js.native
  object RvHookupJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RvHookupJS)
  
  def apply() = jsFnComponent()

}
    