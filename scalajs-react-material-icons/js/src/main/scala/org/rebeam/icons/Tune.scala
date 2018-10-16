
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Tune {

  @JSImport("@material-ui/icons/Tune", JSImport.Default)
  @js.native
  object TuneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TuneJS)
  
  def apply() = jsFnComponent()

}
    