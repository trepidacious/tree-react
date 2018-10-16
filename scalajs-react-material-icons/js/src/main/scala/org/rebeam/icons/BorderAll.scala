
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BorderAll {

  @JSImport("@material-ui/icons/BorderAll", JSImport.Default)
  @js.native
  object BorderAllJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BorderAllJS)
  
  def apply() = jsFnComponent()

}
    