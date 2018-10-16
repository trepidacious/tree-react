
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object OpenWith {

  @JSImport("@material-ui/icons/OpenWith", JSImport.Default)
  @js.native
  object OpenWithJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](OpenWithJS)
  
  def apply() = jsFnComponent()

}
    