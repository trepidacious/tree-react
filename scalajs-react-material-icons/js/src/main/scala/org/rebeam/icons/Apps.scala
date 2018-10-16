
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Apps {

  @JSImport("@material-ui/icons/Apps", JSImport.Default)
  @js.native
  object AppsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AppsJS)
  
  def apply() = jsFnComponent()

}
    