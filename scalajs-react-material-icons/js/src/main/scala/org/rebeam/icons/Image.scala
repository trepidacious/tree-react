
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Image {

  @JSImport("@material-ui/icons/Image", JSImport.Default)
  @js.native
  object ImageJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ImageJS)
  
  def apply() = jsFnComponent()

}
    