
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Category {

  @JSImport("@material-ui/icons/Category", JSImport.Default)
  @js.native
  object CategoryJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CategoryJS)
  
  def apply() = jsFnComponent()

}
    