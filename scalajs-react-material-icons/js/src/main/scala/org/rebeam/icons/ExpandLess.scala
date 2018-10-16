
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ExpandLess {

  @JSImport("@material-ui/icons/ExpandLess", JSImport.Default)
  @js.native
  object ExpandLessJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ExpandLessJS)
  
  def apply() = jsFnComponent()

}
    