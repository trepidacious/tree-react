
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Label {

  @JSImport("@material-ui/icons/Label", JSImport.Default)
  @js.native
  object LabelJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LabelJS)
  
  def apply() = jsFnComponent()

}
    