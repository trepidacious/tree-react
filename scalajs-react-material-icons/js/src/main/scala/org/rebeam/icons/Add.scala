
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Add {

  @JSImport("@material-ui/icons/Add", JSImport.Default)
  @js.native
  object AddJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddJS)
  
  def apply() = jsFnComponent()

}
    