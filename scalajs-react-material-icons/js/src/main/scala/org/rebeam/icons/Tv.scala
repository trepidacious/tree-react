
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Tv {

  @JSImport("@material-ui/icons/Tv", JSImport.Default)
  @js.native
  object TvJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TvJS)
  
  def apply() = jsFnComponent()

}
    