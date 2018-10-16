
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MovieFilter {

  @JSImport("@material-ui/icons/MovieFilter", JSImport.Default)
  @js.native
  object MovieFilterJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MovieFilterJS)
  
  def apply() = jsFnComponent()

}
    