
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FolderShared {

  @JSImport("@material-ui/icons/FolderShared", JSImport.Default)
  @js.native
  object FolderSharedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FolderSharedJS)
  
  def apply() = jsFnComponent()

}
    