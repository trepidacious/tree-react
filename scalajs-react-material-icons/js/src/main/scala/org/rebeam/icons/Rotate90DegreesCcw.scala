
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Rotate90DegreesCcw {

  @JSImport("@material-ui/icons/Rotate90DegreesCcw", JSImport.Default)
  @js.native
  object Rotate90DegreesCcwJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Rotate90DegreesCcwJS)
  
  def apply() = jsFnComponent()

}
    