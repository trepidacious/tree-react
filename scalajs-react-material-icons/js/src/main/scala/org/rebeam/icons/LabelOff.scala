
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LabelOff {

  @JSImport("@material-ui/icons/LabelOff", JSImport.Default)
  @js.native
  object LabelOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LabelOffJS)
  
  def apply() = jsFnComponent()

}
    