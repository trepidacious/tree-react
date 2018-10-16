
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatBold {

  @JSImport("@material-ui/icons/FormatBold", JSImport.Default)
  @js.native
  object FormatBoldJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatBoldJS)
  
  def apply() = jsFnComponent()

}
    