
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TextFields {

  @JSImport("@material-ui/icons/TextFields", JSImport.Default)
  @js.native
  object TextFieldsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TextFieldsJS)
  
  def apply() = jsFnComponent()

}
    