
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object StoreMallDirectory {

  @JSImport("@material-ui/icons/StoreMallDirectory", JSImport.Default)
  @js.native
  object StoreMallDirectoryJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StoreMallDirectoryJS)
  
  def apply() = jsFnComponent()

}
    