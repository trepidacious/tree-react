
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Contacts {

  @JSImport("@material-ui/icons/Contacts", JSImport.Default)
  @js.native
  object ContactsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ContactsJS)
  
  def apply() = jsFnComponent()

}
    