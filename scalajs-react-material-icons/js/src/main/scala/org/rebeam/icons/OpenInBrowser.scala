
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object OpenInBrowser {

  @JSImport("@material-ui/icons/OpenInBrowser", JSImport.Default)
  @js.native
  object OpenInBrowserJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](OpenInBrowserJS)
  
  def apply() = jsFnComponent()

}
    