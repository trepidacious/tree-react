
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Store {

  @JSImport("@material-ui/icons/Store", JSImport.Default)
  @js.native
  object StoreJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StoreJS)
  
  def apply() = jsFnComponent()

}
    