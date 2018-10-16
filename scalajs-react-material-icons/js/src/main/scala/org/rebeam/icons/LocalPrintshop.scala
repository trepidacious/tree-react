
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalPrintshop {

  @JSImport("@material-ui/icons/LocalPrintshop", JSImport.Default)
  @js.native
  object LocalPrintshopJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalPrintshopJS)
  
  def apply() = jsFnComponent()

}
    