
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Exposure {

  @JSImport("@material-ui/icons/Exposure", JSImport.Default)
  @js.native
  object ExposureJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ExposureJS)
  
  def apply() = jsFnComponent()

}
    