
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsBackupRestore {

  @JSImport("@material-ui/icons/SettingsBackupRestore", JSImport.Default)
  @js.native
  object SettingsBackupRestoreJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsBackupRestoreJS)
  
  def apply() = jsFnComponent()

}
    