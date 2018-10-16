
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HdrWeak {

  @JSImport("@material-ui/icons/HdrWeak", JSImport.Default)
  @js.native
  object HdrWeakJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HdrWeakJS)
  
  def apply() = jsFnComponent()

}
    