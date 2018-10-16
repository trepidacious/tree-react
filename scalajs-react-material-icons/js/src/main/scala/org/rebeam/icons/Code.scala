
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Code {

  @JSImport("@material-ui/icons/Code", JSImport.Default)
  @js.native
  object CodeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CodeJS)
  
  def apply() = jsFnComponent()

}
    