
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LibraryMusic {

  @JSImport("@material-ui/icons/LibraryMusic", JSImport.Default)
  @js.native
  object LibraryMusicJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LibraryMusicJS)
  
  def apply() = jsFnComponent()

}
    