
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Photo {

  @JSImport("@material-ui/icons/Photo", JSImport.Default)
  @js.native
  object PhotoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhotoJS)
  
  def apply() = jsFnComponent()

}
    