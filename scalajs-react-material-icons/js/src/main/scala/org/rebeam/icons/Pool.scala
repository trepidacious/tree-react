
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Pool {

  @JSImport("@material-ui/icons/Pool", JSImport.Default)
  @js.native
  object PoolJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PoolJS)
  
  def apply() = jsFnComponent()

}
    