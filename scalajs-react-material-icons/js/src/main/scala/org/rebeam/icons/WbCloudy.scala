
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WbCloudy {

  @JSImport("@material-ui/icons/WbCloudy", JSImport.Default)
  @js.native
  object WbCloudyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WbCloudyJS)
  
  def apply() = jsFnComponent()

}
    