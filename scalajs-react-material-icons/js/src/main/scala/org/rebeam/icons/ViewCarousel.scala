
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewCarousel {

  @JSImport("@material-ui/icons/ViewCarousel", JSImport.Default)
  @js.native
  object ViewCarouselJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewCarouselJS)
  
  def apply() = jsFnComponent()

}
    