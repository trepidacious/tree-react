
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BeachAccess {

  @JSImport("@material-ui/icons/BeachAccess", JSImport.Default)
  @js.native
  object BeachAccessJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BeachAccessJS)
  
  def apply() = jsFnComponent()

}
    