
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsRemote {

  @JSImport("@material-ui/icons/SettingsRemote", JSImport.Default)
  @js.native
  object SettingsRemoteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsRemoteJS)
  
  def apply() = jsFnComponent()

}
    