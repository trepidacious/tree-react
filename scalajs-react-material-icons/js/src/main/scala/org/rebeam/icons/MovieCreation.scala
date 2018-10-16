
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MovieCreation {

  @JSImport("@material-ui/icons/MovieCreation", JSImport.Default)
  @js.native
  object MovieCreationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MovieCreationJS)
  
  def apply() = jsFnComponent()

}
    