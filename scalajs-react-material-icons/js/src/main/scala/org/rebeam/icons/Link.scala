
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Link {

  @JSImport("@material-ui/icons/Link", JSImport.Default)
  @js.native
  object LinkJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LinkJS)
  
  def apply() = jsFnComponent()

}
    