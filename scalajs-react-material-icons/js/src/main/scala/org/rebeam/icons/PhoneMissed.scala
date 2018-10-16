
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhoneMissed {

  @JSImport("@material-ui/icons/PhoneMissed", JSImport.Default)
  @js.native
  object PhoneMissedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhoneMissedJS)
  
  def apply() = jsFnComponent()

}
    