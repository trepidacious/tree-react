
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Subway {

  @JSImport("@material-ui/icons/Subway", JSImport.Default)
  @js.native
  object SubwayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SubwayJS)
  
  def apply() = jsFnComponent()

}
    