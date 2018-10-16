
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Title {

  @JSImport("@material-ui/icons/Title", JSImport.Default)
  @js.native
  object TitleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TitleJS)
  
  def apply() = jsFnComponent()

}
    