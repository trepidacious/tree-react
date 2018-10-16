
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NotificationImportant {

  @JSImport("@material-ui/icons/NotificationImportant", JSImport.Default)
  @js.native
  object NotificationImportantJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NotificationImportantJS)
  
  def apply() = jsFnComponent()

}
    