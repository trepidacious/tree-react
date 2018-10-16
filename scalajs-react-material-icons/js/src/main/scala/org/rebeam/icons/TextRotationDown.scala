
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TextRotationDown {

  @JSImport("@material-ui/icons/TextRotationDown", JSImport.Default)
  @js.native
  object TextRotationDownJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TextRotationDownJS)
  
  def apply() = jsFnComponent()

}
    