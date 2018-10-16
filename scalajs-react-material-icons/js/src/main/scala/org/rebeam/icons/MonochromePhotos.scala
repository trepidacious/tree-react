
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MonochromePhotos {

  @JSImport("@material-ui/icons/MonochromePhotos", JSImport.Default)
  @js.native
  object MonochromePhotosJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MonochromePhotosJS)
  
  def apply() = jsFnComponent()

}
    