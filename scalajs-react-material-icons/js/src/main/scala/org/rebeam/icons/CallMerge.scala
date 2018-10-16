
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CallMerge {

  @JSImport("@material-ui/icons/CallMerge", JSImport.Default)
  @js.native
  object CallMergeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CallMergeJS)
  
  def apply() = jsFnComponent()

}
    