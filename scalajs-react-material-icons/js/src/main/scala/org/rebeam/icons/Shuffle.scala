
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Shuffle {

  @JSImport("@material-ui/icons/Shuffle", JSImport.Default)
  @js.native
  object ShuffleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ShuffleJS)
  
  def apply() = jsFnComponent()

}
    