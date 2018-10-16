
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Tab {

  @JSImport("@material-ui/icons/Tab", JSImport.Default)
  @js.native
  object TabJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TabJS)
  
  def apply() = jsFnComponent()

}
    