
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FiberManualRecord {

  @JSImport("@material-ui/icons/FiberManualRecord", JSImport.Default)
  @js.native
  object FiberManualRecordJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FiberManualRecordJS)
  
  def apply() = jsFnComponent()

}
    