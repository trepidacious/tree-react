
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BorderOuter {

  @JSImport("@material-ui/icons/BorderOuter", JSImport.Default)
  @js.native
  object BorderOuterJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BorderOuterJS)
  
  def apply() = jsFnComponent()

}
    