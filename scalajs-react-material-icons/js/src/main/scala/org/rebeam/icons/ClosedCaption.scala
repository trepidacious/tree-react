
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ClosedCaption {

  @JSImport("@material-ui/icons/ClosedCaption", JSImport.Default)
  @js.native
  object ClosedCaptionJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ClosedCaptionJS)
  
  def apply() = jsFnComponent()

}
    