
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Iso {

  @JSImport("@material-ui/icons/Iso", JSImport.Default)
  @js.native
  object IsoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](IsoJS)
  
  def apply() = jsFnComponent()

}
    