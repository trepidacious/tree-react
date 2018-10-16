
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhotoSizeSelectLarge {

  @JSImport("@material-ui/icons/PhotoSizeSelectLarge", JSImport.Default)
  @js.native
  object PhotoSizeSelectLargeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhotoSizeSelectLargeJS)
  
  def apply() = jsFnComponent()

}
    