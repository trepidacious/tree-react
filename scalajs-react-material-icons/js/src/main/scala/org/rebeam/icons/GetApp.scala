
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object GetApp {

  @JSImport("@material-ui/icons/GetApp", JSImport.Default)
  @js.native
  object GetAppJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GetAppJS)
  
  def apply() = jsFnComponent()

}
    