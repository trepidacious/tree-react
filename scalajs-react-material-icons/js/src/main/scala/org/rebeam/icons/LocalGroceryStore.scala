
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalGroceryStore {

  @JSImport("@material-ui/icons/LocalGroceryStore", JSImport.Default)
  @js.native
  object LocalGroceryStoreJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalGroceryStoreJS)
  
  def apply() = jsFnComponent()

}
    