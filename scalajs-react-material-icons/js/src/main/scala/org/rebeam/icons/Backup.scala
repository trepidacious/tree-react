
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Backup {

  @JSImport("@material-ui/icons/Backup", JSImport.Default)
  @js.native
  object BackupJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BackupJS)
  
  def apply() = jsFnComponent()

}
    