
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Movie {

  @JSImport("@material-ui/icons/Movie", JSImport.Default)
  @js.native
  object MovieJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MovieJS)
  
  def apply() = jsFnComponent()

}
    