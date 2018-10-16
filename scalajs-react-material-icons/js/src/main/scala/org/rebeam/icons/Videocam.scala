
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Videocam {

  @JSImport("@material-ui/icons/Videocam", JSImport.Default)
  @js.native
  object VideocamJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VideocamJS)
  
  def apply() = jsFnComponent()

}
    