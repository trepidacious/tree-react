
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FilterHdr {

  @JSImport("@material-ui/icons/FilterHdr", JSImport.Default)
  @js.native
  object FilterHdrJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FilterHdrJS)
  
  def apply() = jsFnComponent()

}
    