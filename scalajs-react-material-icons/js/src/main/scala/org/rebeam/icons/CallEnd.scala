
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CallEnd {

  @JSImport("@material-ui/icons/CallEnd", JSImport.Default)
  @js.native
  object CallEndJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CallEndJS)
  
  def apply() = jsFnComponent()

}
    