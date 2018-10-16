
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Save {

  @JSImport("@material-ui/icons/Save", JSImport.Default)
  @js.native
  object SaveJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SaveJS)
  
  def apply() = jsFnComponent()

}
    