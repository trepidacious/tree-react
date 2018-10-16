
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Edit {

  @JSImport("@material-ui/icons/Edit", JSImport.Default)
  @js.native
  object EditJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EditJS)
  
  def apply() = jsFnComponent()

}
    