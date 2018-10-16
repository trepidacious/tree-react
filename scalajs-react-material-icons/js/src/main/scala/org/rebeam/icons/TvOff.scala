
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TvOff {

  @JSImport("@material-ui/icons/TvOff", JSImport.Default)
  @js.native
  object TvOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TvOffJS)
  
  def apply() = jsFnComponent()

}
    