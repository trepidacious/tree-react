
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AlternateEmail {

  @JSImport("@material-ui/icons/AlternateEmail", JSImport.Default)
  @js.native
  object AlternateEmailJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AlternateEmailJS)
  
  def apply() = jsFnComponent()

}
    