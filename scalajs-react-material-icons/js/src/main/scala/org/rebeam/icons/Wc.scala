
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Wc {

  @JSImport("@material-ui/icons/Wc", JSImport.Default)
  @js.native
  object WcJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WcJS)
  
  def apply() = jsFnComponent()

}
    