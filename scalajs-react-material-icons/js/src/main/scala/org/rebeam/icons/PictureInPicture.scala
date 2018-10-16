
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PictureInPicture {

  @JSImport("@material-ui/icons/PictureInPicture", JSImport.Default)
  @js.native
  object PictureInPictureJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PictureInPictureJS)
  
  def apply() = jsFnComponent()

}
    