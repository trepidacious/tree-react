
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Phonelink {

  @JSImport("@material-ui/icons/Phonelink", JSImport.Default)
  @js.native
  object PhonelinkJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhonelinkJS)
  
  def apply() = jsFnComponent()

}
    