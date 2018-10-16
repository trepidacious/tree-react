
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PlayCircleOutline {

  @JSImport("@material-ui/icons/PlayCircleOutline", JSImport.Default)
  @js.native
  object PlayCircleOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PlayCircleOutlineJS)
  
  def apply() = jsFnComponent()

}
    