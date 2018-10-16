
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AlarmAdd {

  @JSImport("@material-ui/icons/AlarmAdd", JSImport.Default)
  @js.native
  object AlarmAddJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AlarmAddJS)
  
  def apply() = jsFnComponent()

}
    