
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Details {

  @JSImport("@material-ui/icons/Details", JSImport.Default)
  @js.native
  object DetailsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DetailsJS)
  
  def apply() = jsFnComponent()

}
    