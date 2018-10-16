
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ImageAspectRatio {

  @JSImport("@material-ui/icons/ImageAspectRatio", JSImport.Default)
  @js.native
  object ImageAspectRatioJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ImageAspectRatioJS)
  
  def apply() = jsFnComponent()

}
    