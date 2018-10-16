
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhotoSizeSelectSmall {

  @JSImport("@material-ui/icons/PhotoSizeSelectSmall", JSImport.Default)
  @js.native
  object PhotoSizeSelectSmallJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhotoSizeSelectSmallJS)
  
  def apply() = jsFnComponent()

}
    