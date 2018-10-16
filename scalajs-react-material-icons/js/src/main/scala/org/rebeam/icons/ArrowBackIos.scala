
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArrowBackIos {

  @JSImport("@material-ui/icons/ArrowBackIos", JSImport.Default)
  @js.native
  object ArrowBackIosJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArrowBackIosJS)
  
  def apply() = jsFnComponent()

}
    