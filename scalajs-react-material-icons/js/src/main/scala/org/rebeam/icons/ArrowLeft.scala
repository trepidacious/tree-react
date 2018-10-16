
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArrowLeft {

  @JSImport("@material-ui/icons/ArrowLeft", JSImport.Default)
  @js.native
  object ArrowLeftJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArrowLeftJS)
  
  def apply() = jsFnComponent()

}
    