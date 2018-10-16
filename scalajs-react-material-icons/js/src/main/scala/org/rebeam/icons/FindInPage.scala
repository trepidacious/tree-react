
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FindInPage {

  @JSImport("@material-ui/icons/FindInPage", JSImport.Default)
  @js.native
  object FindInPageJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FindInPageJS)
  
  def apply() = jsFnComponent()

}
    