
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalPostOffice {

  @JSImport("@material-ui/icons/LocalPostOffice", JSImport.Default)
  @js.native
  object LocalPostOfficeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalPostOfficeJS)
  
  def apply() = jsFnComponent()

}
    