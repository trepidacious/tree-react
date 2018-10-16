
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CreateNewFolder {

  @JSImport("@material-ui/icons/CreateNewFolder", JSImport.Default)
  @js.native
  object CreateNewFolderJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CreateNewFolderJS)
  
  def apply() = jsFnComponent()

}
    