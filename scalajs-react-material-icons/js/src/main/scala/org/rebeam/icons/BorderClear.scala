
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BorderClear {

  @JSImport("@material-ui/icons/BorderClear", JSImport.Default)
  @js.native
  object BorderClearJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BorderClearJS)
  
  def apply() = jsFnComponent()

}
    