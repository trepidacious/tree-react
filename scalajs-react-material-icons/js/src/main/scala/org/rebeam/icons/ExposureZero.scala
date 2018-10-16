
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ExposureZero {

  @JSImport("@material-ui/icons/ExposureZero", JSImport.Default)
  @js.native
  object ExposureZeroJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ExposureZeroJS)
  
  def apply() = jsFnComponent()

}
    