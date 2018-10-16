
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RestorePage {

  @JSImport("@material-ui/icons/RestorePage", JSImport.Default)
  @js.native
  object RestorePageJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RestorePageJS)
  
  def apply() = jsFnComponent()

}
    