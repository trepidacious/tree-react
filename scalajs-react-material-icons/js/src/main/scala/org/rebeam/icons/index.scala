
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object index {

  @JSImport("@material-ui/icons/index", JSImport.Default)
  @js.native
  object indexJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](indexJS)
  
  def apply() = jsFnComponent()

}
    