
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalActivity {

  @JSImport("@material-ui/icons/LocalActivity", JSImport.Default)
  @js.native
  object LocalActivityJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalActivityJS)
  
  def apply() = jsFnComponent()

}
    