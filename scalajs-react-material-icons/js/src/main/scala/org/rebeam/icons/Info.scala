
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Info {

  @JSImport("@material-ui/icons/Info", JSImport.Default)
  @js.native
  object InfoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](InfoJS)
  
  def apply() = jsFnComponent()

}
    