
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ReplyAll {

  @JSImport("@material-ui/icons/ReplyAll", JSImport.Default)
  @js.native
  object ReplyAllJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ReplyAllJS)
  
  def apply() = jsFnComponent()

}
    