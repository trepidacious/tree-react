
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object GridOn {

  @JSImport("@material-ui/icons/GridOn", JSImport.Default)
  @js.native
  object GridOnJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GridOnJS)
  
  def apply() = jsFnComponent()

}
    