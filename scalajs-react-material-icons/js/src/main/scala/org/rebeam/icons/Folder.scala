
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Folder {

  @JSImport("@material-ui/icons/Folder", JSImport.Default)
  @js.native
  object FolderJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FolderJS)
  
  def apply() = jsFnComponent()

}
    