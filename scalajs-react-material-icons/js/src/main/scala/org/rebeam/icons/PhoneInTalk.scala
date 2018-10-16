
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhoneInTalk {

  @JSImport("@material-ui/icons/PhoneInTalk", JSImport.Default)
  @js.native
  object PhoneInTalkJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhoneInTalkJS)
  
  def apply() = jsFnComponent()

}
    