
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FindReplace {

  @JSImport("@material-ui/icons/FindReplace", JSImport.Default)
  @js.native
  object FindReplaceJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FindReplaceJS)
  
  def apply() = jsFnComponent()

}
    