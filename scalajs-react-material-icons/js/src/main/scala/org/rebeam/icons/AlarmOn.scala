
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AlarmOn {

  @JSImport("@material-ui/icons/AlarmOn", JSImport.Default)
  @js.native
  object AlarmOnJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AlarmOnJS)
  
  def apply() = jsFnComponent()

}
    