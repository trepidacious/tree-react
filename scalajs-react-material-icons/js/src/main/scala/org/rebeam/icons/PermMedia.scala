
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PermMedia {

  @JSImport("@material-ui/icons/PermMedia", JSImport.Default)
  @js.native
  object PermMediaJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PermMediaJS)
  
  def apply() = jsFnComponent()

}
    