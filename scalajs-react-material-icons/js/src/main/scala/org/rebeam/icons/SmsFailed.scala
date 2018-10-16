
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SmsFailed {

  @JSImport("@material-ui/icons/SmsFailed", JSImport.Default)
  @js.native
  object SmsFailedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SmsFailedJS)
  
  def apply() = jsFnComponent()

}
    