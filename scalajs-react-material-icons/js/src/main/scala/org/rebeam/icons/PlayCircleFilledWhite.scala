
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PlayCircleFilledWhite {

  @JSImport("@material-ui/icons/PlayCircleFilledWhite", JSImport.Default)
  @js.native
  object PlayCircleFilledWhiteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PlayCircleFilledWhiteJS)
  
  def apply() = jsFnComponent()

}
    