
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HdrStrong {

  @JSImport("@material-ui/icons/HdrStrong", JSImport.Default)
  @js.native
  object HdrStrongJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HdrStrongJS)
  
  def apply() = jsFnComponent()

}
    