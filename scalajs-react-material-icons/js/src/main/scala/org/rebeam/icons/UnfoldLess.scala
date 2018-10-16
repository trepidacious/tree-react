
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object UnfoldLess {

  @JSImport("@material-ui/icons/UnfoldLess", JSImport.Default)
  @js.native
  object UnfoldLessJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](UnfoldLessJS)
  
  def apply() = jsFnComponent()

}
    