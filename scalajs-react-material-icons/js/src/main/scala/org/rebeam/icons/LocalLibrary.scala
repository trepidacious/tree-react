
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalLibrary {

  @JSImport("@material-ui/icons/LocalLibrary", JSImport.Default)
  @js.native
  object LocalLibraryJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalLibraryJS)
  
  def apply() = jsFnComponent()

}
    