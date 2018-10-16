
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ImportContacts {

  @JSImport("@material-ui/icons/ImportContacts", JSImport.Default)
  @js.native
  object ImportContactsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ImportContactsJS)
  
  def apply() = jsFnComponent()

}
    