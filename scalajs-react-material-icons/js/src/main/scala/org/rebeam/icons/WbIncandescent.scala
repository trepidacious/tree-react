
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WbIncandescent {

  @JSImport("@material-ui/icons/WbIncandescent", JSImport.Default)
  @js.native
  object WbIncandescentJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WbIncandescentJS)
  
  def apply() = jsFnComponent()

}
    