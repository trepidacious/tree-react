
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocationSearching {

  @JSImport("@material-ui/icons/LocationSearching", JSImport.Default)
  @js.native
  object LocationSearchingJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocationSearchingJS)
  
  def apply() = jsFnComponent()

}
    