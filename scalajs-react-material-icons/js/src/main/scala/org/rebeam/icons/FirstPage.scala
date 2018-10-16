
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FirstPage {

  @JSImport("@material-ui/icons/FirstPage", JSImport.Default)
  @js.native
  object FirstPageJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FirstPageJS)
  
  def apply() = jsFnComponent()

}
    