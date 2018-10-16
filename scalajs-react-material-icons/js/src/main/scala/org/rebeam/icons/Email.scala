
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Email {

  @JSImport("@material-ui/icons/Email", JSImport.Default)
  @js.native
  object EmailJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EmailJS)
  
  def apply() = jsFnComponent()

}
    