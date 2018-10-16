
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RoundedCorner {

  @JSImport("@material-ui/icons/RoundedCorner", JSImport.Default)
  @js.native
  object RoundedCornerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RoundedCornerJS)
  
  def apply() = jsFnComponent()

}
    