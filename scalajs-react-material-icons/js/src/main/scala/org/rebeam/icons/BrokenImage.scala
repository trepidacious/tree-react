
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BrokenImage {

  @JSImport("@material-ui/icons/BrokenImage", JSImport.Default)
  @js.native
  object BrokenImageJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BrokenImageJS)
  
  def apply() = jsFnComponent()

}
    