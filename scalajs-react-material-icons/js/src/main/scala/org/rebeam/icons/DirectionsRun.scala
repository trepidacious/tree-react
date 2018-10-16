
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DirectionsRun {

  @JSImport("@material-ui/icons/DirectionsRun", JSImport.Default)
  @js.native
  object DirectionsRunJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DirectionsRunJS)
  
  def apply() = jsFnComponent()

}
    