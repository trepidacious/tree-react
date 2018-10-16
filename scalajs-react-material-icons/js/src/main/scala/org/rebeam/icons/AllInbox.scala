
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AllInbox {

  @JSImport("@material-ui/icons/AllInbox", JSImport.Default)
  @js.native
  object AllInboxJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AllInboxJS)
  
  def apply() = jsFnComponent()

}
    