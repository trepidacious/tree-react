
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PictureAsPdf {

  @JSImport("@material-ui/icons/PictureAsPdf", JSImport.Default)
  @js.native
  object PictureAsPdfJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PictureAsPdfJS)
  
  def apply() = jsFnComponent()

}
    