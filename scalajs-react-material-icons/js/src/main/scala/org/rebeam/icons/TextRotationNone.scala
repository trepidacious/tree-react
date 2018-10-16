
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TextRotationNone {

  @JSImport("@material-ui/icons/TextRotationNone", JSImport.Default)
  @js.native
  object TextRotationNoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TextRotationNoneJS)
  
  def apply() = jsFnComponent()

}
    