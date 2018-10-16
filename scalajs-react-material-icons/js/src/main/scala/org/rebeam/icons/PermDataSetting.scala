
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PermDataSetting {

  @JSImport("@material-ui/icons/PermDataSetting", JSImport.Default)
  @js.native
  object PermDataSettingJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PermDataSettingJS)
  
  def apply() = jsFnComponent()

}
    