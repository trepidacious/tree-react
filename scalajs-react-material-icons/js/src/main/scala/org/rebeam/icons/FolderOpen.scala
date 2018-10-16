
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FolderOpen {

  @JSImport("@material-ui/icons/FolderOpen", JSImport.Default)
  @js.native
  object FolderOpenJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FolderOpenJS)
  
  def apply() = jsFnComponent()

}
    