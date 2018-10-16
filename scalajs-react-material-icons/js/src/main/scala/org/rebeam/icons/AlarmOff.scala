
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AlarmOff {

  @JSImport("@material-ui/icons/AlarmOff", JSImport.Default)
  @js.native
  object AlarmOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AlarmOffJS)
  
  def apply() = jsFnComponent()

}
    