
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LabelImportant {

  @JSImport("@material-ui/icons/LabelImportant", JSImport.Default)
  @js.native
  object LabelImportantJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LabelImportantJS)
  
  def apply() = jsFnComponent()

}
    