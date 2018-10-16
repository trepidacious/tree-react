
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhotoLibrary {

  @JSImport("@material-ui/icons/PhotoLibrary", JSImport.Default)
  @js.native
  object PhotoLibraryJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhotoLibraryJS)
  
  def apply() = jsFnComponent()

}
    