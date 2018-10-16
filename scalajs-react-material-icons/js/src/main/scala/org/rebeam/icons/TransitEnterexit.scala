
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TransitEnterexit {

  @JSImport("@material-ui/icons/TransitEnterexit", JSImport.Default)
  @js.native
  object TransitEnterexitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TransitEnterexitJS)
  
  def apply() = jsFnComponent()

}
    