
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BorderInner {

  @JSImport("@material-ui/icons/BorderInner", JSImport.Default)
  @js.native
  object BorderInnerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BorderInnerJS)
  
  def apply() = jsFnComponent()

}
    