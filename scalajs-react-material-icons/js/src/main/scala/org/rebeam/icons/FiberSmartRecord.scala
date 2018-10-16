
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FiberSmartRecord {

  @JSImport("@material-ui/icons/FiberSmartRecord", JSImport.Default)
  @js.native
  object FiberSmartRecordJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FiberSmartRecordJS)
  
  def apply() = jsFnComponent()

}
    