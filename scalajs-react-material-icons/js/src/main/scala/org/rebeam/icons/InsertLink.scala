
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object InsertLink {

  @JSImport("@material-ui/icons/InsertLink", JSImport.Default)
  @js.native
  object InsertLinkJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](InsertLinkJS)
  
  def apply() = jsFnComponent()

}
    