
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ContactMail {

  @JSImport("@material-ui/icons/ContactMail", JSImport.Default)
  @js.native
  object ContactMailJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ContactMailJS)
  
  def apply() = jsFnComponent()

}
    