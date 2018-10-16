
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FilterFrames {

  @JSImport("@material-ui/icons/FilterFrames", JSImport.Default)
  @js.native
  object FilterFramesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FilterFramesJS)
  
  def apply() = jsFnComponent()

}
    