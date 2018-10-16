
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewDay {

  @JSImport("@material-ui/icons/ViewDay", JSImport.Default)
  @js.native
  object ViewDayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewDayJS)
  
  def apply() = jsFnComponent()

}
    