
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BorderLeft {

  @JSImport("@material-ui/icons/BorderLeft", JSImport.Default)
  @js.native
  object BorderLeftJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BorderLeftJS)
  
  def apply() = jsFnComponent()

}
    