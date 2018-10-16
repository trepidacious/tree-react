
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MailOutline {

  @JSImport("@material-ui/icons/MailOutline", JSImport.Default)
  @js.native
  object MailOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MailOutlineJS)
  
  def apply() = jsFnComponent()

}
    