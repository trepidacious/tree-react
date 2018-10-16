
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HdrOn {

  @JSImport("@material-ui/icons/HdrOn", JSImport.Default)
  @js.native
  object HdrOnJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HdrOnJS)
  
  def apply() = jsFnComponent()

}
    