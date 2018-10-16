
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object InsertDriveFile {

  @JSImport("@material-ui/icons/InsertDriveFile", JSImport.Default)
  @js.native
  object InsertDriveFileJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](InsertDriveFileJS)
  
  def apply() = jsFnComponent()

}
    