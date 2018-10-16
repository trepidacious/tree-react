
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Mail {

  @JSImport("@material-ui/icons/Mail", JSImport.Default)
  @js.native
  object MailJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MailJS)
  
  def apply() = jsFnComponent()

}
    