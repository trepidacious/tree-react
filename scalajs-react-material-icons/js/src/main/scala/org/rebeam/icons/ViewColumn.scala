
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewColumn {

  @JSImport("@material-ui/icons/ViewColumn", JSImport.Default)
  @js.native
  object ViewColumnJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewColumnJS)
  
  def apply() = jsFnComponent()

}
    