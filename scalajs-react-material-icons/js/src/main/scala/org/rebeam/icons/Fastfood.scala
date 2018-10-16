
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Fastfood {

  @JSImport("@material-ui/icons/Fastfood", JSImport.Default)
  @js.native
  object FastfoodJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FastfoodJS)
  
  def apply() = jsFnComponent()

}
    