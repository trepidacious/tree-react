
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DataUsage {

  @JSImport("@material-ui/icons/DataUsage", JSImport.Default)
  @js.native
  object DataUsageJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DataUsageJS)
  
  def apply() = jsFnComponent()

}
    