
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Adb {

  @JSImport("@material-ui/icons/Adb", JSImport.Default)
  @js.native
  object AdbJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AdbJS)
  
  def apply() = jsFnComponent()

}
    