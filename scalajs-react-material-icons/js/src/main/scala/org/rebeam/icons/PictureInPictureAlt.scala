
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PictureInPictureAlt {

  @JSImport("@material-ui/icons/PictureInPictureAlt", JSImport.Default)
  @js.native
  object PictureInPictureAltJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PictureInPictureAltJS)
  
  def apply() = jsFnComponent()

}
    