
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Textsms {

  @JSImport("@material-ui/icons/Textsms", JSImport.Default)
  @js.native
  object TextsmsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TextsmsJS)
  
  def apply() = jsFnComponent()

}
    