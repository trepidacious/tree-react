
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VideoLibrary {

  @JSImport("@material-ui/icons/VideoLibrary", JSImport.Default)
  @js.native
  object VideoLibraryJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VideoLibraryJS)
  
  def apply() = jsFnComponent()

}
    