
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MusicOff {

  @JSImport("@material-ui/icons/MusicOff", JSImport.Default)
  @js.native
  object MusicOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MusicOffJS)
  
  def apply() = jsFnComponent()

}
    