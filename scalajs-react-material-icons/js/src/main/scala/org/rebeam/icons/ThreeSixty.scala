
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ThreeSixty {

  @JSImport("@material-ui/icons/ThreeSixty", JSImport.Default)
  @js.native
  object ThreeSixtyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ThreeSixtyJS)
  
  def apply() = jsFnComponent()

}
    