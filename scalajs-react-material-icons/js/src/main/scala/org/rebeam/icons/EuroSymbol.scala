
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object EuroSymbol {

  @JSImport("@material-ui/icons/EuroSymbol", JSImport.Default)
  @js.native
  object EuroSymbolJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EuroSymbolJS)
  
  def apply() = jsFnComponent()

}
    