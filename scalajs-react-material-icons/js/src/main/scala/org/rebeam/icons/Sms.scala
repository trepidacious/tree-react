
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Sms {

  @JSImport("@material-ui/icons/Sms", JSImport.Default)
  @js.native
  object SmsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SmsJS)
  
  def apply() = jsFnComponent()

}
    