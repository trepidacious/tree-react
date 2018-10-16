
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhotoFilter {

  @JSImport("@material-ui/icons/PhotoFilter", JSImport.Default)
  @js.native
  object PhotoFilterJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhotoFilterJS)
  
  def apply() = jsFnComponent()

}
    