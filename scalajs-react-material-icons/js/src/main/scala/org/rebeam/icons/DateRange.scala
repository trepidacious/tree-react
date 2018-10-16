
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DateRange {

  @JSImport("@material-ui/icons/DateRange", JSImport.Default)
  @js.native
  object DateRangeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DateRangeJS)
  
  def apply() = jsFnComponent()

}
    