
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DeleteForever {

  @JSImport("@material-ui/icons/DeleteForever", JSImport.Default)
  @js.native
  object DeleteForeverJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DeleteForeverJS)
  
  def apply() = jsFnComponent()

}
    