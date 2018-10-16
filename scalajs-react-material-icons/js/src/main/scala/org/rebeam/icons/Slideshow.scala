
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Slideshow {

  @JSImport("@material-ui/icons/Slideshow", JSImport.Default)
  @js.native
  object SlideshowJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SlideshowJS)
  
  def apply() = jsFnComponent()

}
    