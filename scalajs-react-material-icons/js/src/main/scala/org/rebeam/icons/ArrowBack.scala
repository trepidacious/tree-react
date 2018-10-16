
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArrowBack {

  @JSImport("@material-ui/icons/ArrowBack", JSImport.Default)
  @js.native
  object ArrowBackJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArrowBackJS)
  
  def apply() = jsFnComponent()

}
    