
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FolderSpecial {

  @JSImport("@material-ui/icons/FolderSpecial", JSImport.Default)
  @js.native
  object FolderSpecialJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FolderSpecialJS)
  
  def apply() = jsFnComponent()

}
    