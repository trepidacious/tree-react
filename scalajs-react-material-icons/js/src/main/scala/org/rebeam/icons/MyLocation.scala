
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MyLocation {

  @JSImport("@material-ui/icons/MyLocation", JSImport.Default)
  @js.native
  object MyLocationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MyLocationJS)
  
  def apply() = jsFnComponent()

}
    